package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void testSettingJobID() {
        Job test1 = new Job();
        Job test2 = new Job();
        assertNotEquals(test1, test2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().toString());
        assertEquals("Desert", testJob.getLocation().toString());
        assertEquals("Quality control", testJob.getPositionType().toString());
        assertEquals("Persistence", testJob.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob2.equals(testJob1));
    }

    @Test
    public void testToStringStartsAndEndsWithANewLine() {
        String newLine = System.lineSeparator();
        Job test1 = new Job("test", new Employer("test"), new Location("test"), new PositionType("test"), new CoreCompetency("test"));
        assertTrue(test1.toString().startsWith(newLine));
        assertTrue(test1.toString().endsWith(newLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String newLine = System.lineSeparator();
        String expectedOutput = newLine + "ID: 1" + newLine +
                "Name: test" + newLine +
                "Employer: test" + newLine +
                "Location: test" + newLine +
                "Position Type: test" + newLine +
                "Core Competency: test" +  newLine;
        Job test1 = new Job("test", new Employer("test"), new Location("test"), new PositionType("test"), new CoreCompetency("test"));

    }
}