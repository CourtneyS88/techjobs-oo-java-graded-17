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

        assertEquals(fullJob.getName(), "Product tester");

        assertTrue(fullJob.getEmployer().getValue() == "ACME");
        assertTrue(fullJob.getLocation().getValue() == "Desert");
        assertTrue(fullJob.getPositionType().getValue() == "Quality control");
        assertTrue(fullJob.getCoreCompetency().getValue() == "Persistence");


    }

    @Test
    public void testJobsForEquality() {

        Job job3 = new Job();
        Job job4 = new Job();

        assertFalse(job3.equals(job4));


    }



}
