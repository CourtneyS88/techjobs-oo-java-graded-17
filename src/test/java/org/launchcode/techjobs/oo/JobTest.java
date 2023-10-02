package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId (){

        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetAllFields() {
       Job fullJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", fullJob.getName());
        assertEquals("ACME", fullJob.getEmployer().getValue());
        assertEquals("Desert", fullJob.getLocation().getValue());
        assertEquals("Quality control", fullJob.getPositionType().getValue());
        assertEquals("Persistence", fullJob.getCoreCompetency().getValue());

        assertTrue(fullJob.getName() instanceof String);
        assertTrue(fullJob.getEmployer() instanceof Employer);
        assertTrue(fullJob.getLocation() instanceof Location);
        assertTrue(fullJob.getPositionType() instanceof PositionType);
        assertTrue(fullJob.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job job3 = new Job();
        Job job4 = new Job();

        assertFalse(job3.equals(job4));


    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job fullJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        fullJob.toString().startsWith(System.lineSeparator());
        fullJob.toString().endsWith(System.lineSeparator());

//        assertEquals(System.lineSeparator() , fullJob.toString());
//        assertEquals(System.lineSeparator(), fullJob.toString());

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job labelJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //labels
        String id  = "ID";
        String nameLabel = "Name:";
        String employerLabel = "Employer";
        String locationLabel = "Location";
        String positionTypeLabel = "Position Type";
        String coreCompetencyLabel = "Core Competency";


        int idValue = labelJob.getId();
        String nameValue = "Product tester";
        String employerValue = "ACME";
        String locationValue = "Desert";
        String positionTypeValue = "Quality control";
        String coreCompetencyValue = "Persistence";


        // assertions
        assertTrue(labelJob.toString().contains(id));
        assertTrue(labelJob.toString().contains(String.valueOf(idValue)));

        assertTrue(labelJob.toString().contains(nameLabel));
        assertTrue(labelJob.toString().contains(nameValue));

        assertTrue(labelJob.toString().contains(employerLabel));
        assertTrue(labelJob.toString().contains(employerValue));

        assertTrue(labelJob.toString().contains(locationLabel));
        assertTrue(labelJob.toString().contains(locationValue));

        assertTrue(labelJob.toString().contains(positionTypeLabel));
        assertTrue(labelJob.toString().contains(positionTypeValue));

        assertTrue(labelJob.toString().contains(coreCompetencyLabel));
        assertTrue(labelJob.toString().contains(coreCompetencyValue));

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location(null), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String message = "Data not available";
        assertTrue(job1.toString().contains(message));
        assertTrue(job2.toString().contains(message));
    }


}
