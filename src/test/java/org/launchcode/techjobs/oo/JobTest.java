package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.junit.Assert;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void testSettingJobId() {
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
   public void testToStringStartsAndEndsWithNewLine() {
        String newLine = lineSeparator();
       Job test1 = new Job("test", new Employer("test"), new Location("test"), new PositionType("test"), new CoreCompetency("test"));
        assertTrue(test1.toString().startsWith(newLine));
       assertTrue(test1.toString().endsWith(newLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
       String expectedOutput = lineSeparator() + "ID: 9" + lineSeparator() +
               "Name: test" + lineSeparator() +
               "Employer: test" + lineSeparator() +
              "Location: test" + lineSeparator() +
               "Position Type: test" + lineSeparator() +
              "Core Competency: test" +  lineSeparator();
        Job test1 = new Job("test", new Employer("test"), new Location("test"), new PositionType("test"), new CoreCompetency("test"));
        assertEquals(expectedOutput, test1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String expectedAllEmpty = lineSeparator()  +
                "OOPS! This job does not seem to exist." + lineSeparator();
        Job testAllEmpty = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(expectedAllEmpty, testAllEmpty.toString());
        String expectedNameEmpty = lineSeparator() + "ID: 4" + lineSeparator() +
                "Name: Data not available" + lineSeparator() +
                "Employer: test" + lineSeparator() +
                "Location: test" + lineSeparator() +
                "Position Type: test" + lineSeparator() +
                "Core Competency: test" +  lineSeparator();
        String expectedEmployerEmpty = lineSeparator() + "ID: 5" + lineSeparator() +
                "Name: test" + lineSeparator() +
                "Employer: Data not available" + lineSeparator() +
                "Location: test" + lineSeparator() +
                "Position Type: test" + lineSeparator() +
                "Core Competency: test" +  lineSeparator();
        String expectedLocationEmpty = lineSeparator() + "ID: 6" + lineSeparator() +
                "Name: test" + lineSeparator() +
                "Employer: test" + lineSeparator() +
                "Location: Data not available" + lineSeparator() +
                "Position Type: test" + lineSeparator() +
                "Core Competency: test" +  lineSeparator();
        String expectedPositionTypeEmpty = lineSeparator() + "ID: 7" + lineSeparator() +
                "Name: test" + lineSeparator() +
                "Employer: test" + lineSeparator() +
                "Location: test" + lineSeparator() +
                "Position Type: Data not available" + lineSeparator() +
                "Core Competency: test" +  lineSeparator();
        String expectedCoreCompetencyEmpty = lineSeparator() + "ID: 8" + lineSeparator() +
                "Name: test" + lineSeparator() +
                "Employer: test" + lineSeparator() +
                "Location: test" + lineSeparator() +
                "Position Type: test" + lineSeparator() +
                "Core Competency: Data not available" +  lineSeparator();
        Job testNameEmpty = new Job("", new Employer("test"), new Location("test"), new PositionType("test"), new CoreCompetency("test"));
        Job testEmployerEmpty = new Job("test", new Employer(""), new Location("test"), new PositionType("test"), new CoreCompetency("test"));
        Job testLocationEmpty = new Job("test", new Employer("test"), new Location(""), new PositionType("test"), new CoreCompetency("test"));
        Job testPositionTypeEmpty = new Job("test", new Employer("test"), new Location("test"), new PositionType(""), new CoreCompetency("test"));
        Job testCoreCompetencyEmpty = new Job("test", new Employer("test"), new Location("test"), new PositionType("test"), new CoreCompetency(""));
        assertEquals(expectedNameEmpty, testNameEmpty.toString());
        assertEquals(expectedEmployerEmpty, testEmployerEmpty.toString());
        assertEquals(expectedLocationEmpty, testLocationEmpty.toString());
        assertEquals(expectedPositionTypeEmpty, testPositionTypeEmpty.toString());
        assertEquals(expectedCoreCompetencyEmpty, testCoreCompetencyEmpty.toString());
    }

}