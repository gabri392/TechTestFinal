/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Exceptions.NullNameException;
import Model.Actor;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabriel.p.sousa
 */
public class ActorRepositoryTest {
    private ArrayList<Actor> actorsRepo;
    
    public ActorRepositoryTest() {
        actorsRepo = new ArrayList<Actor>();
        Actor act1 = new Actor("tst1", 1, Float.parseFloat("1.80"), "1 Jan 1990");
        Actor act2 = new Actor("tst2", 2, Float.parseFloat("1.80"), "1 Jan 1994");
        Actor act3 = new Actor("tst3", 3, Float.parseFloat("1.80"), "1 Jan 1998");
        actorsRepo.add(act1);
        actorsRepo.add(act2);
        actorsRepo.add(act3);
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertNewActor method, of class ActorRepository.
     */
    @Test
    public void testInsertNewActor() throws NullNameException {
        System.out.println("insertNewActor");
        String name = "tst4";
        Float heigth = Float.parseFloat("1.88");
        String birth = "20 July 1999";
        ActorRepository instance = new ActorRepository();
        instance.insertNewActor(name, heigth, birth);
        
        if(instance.getAllActors().isEmpty()){
            fail("Repository Empty! Test Failed!");
        }
        
    }

    /**
     * Test of loadActor method, of class ActorRepository.
     */
    @Test
    public void testLoadActor() {

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getActorById method, of class ActorRepository.
     */
    @Test
    public void testGetActorById() throws NullNameException {
        System.out.println("testGetActorById");
        String name = "tst4";
        Float heigth = Float.parseFloat("1.88");
        String birth = "20 July 1999";
        ActorRepository instance = new ActorRepository();
        instance.insertNewActor(name, heigth, birth);
        Actor expResult = new Actor(name, 1, heigth, birth);
        Actor result = instance.getActorById(1);
        assertEquals(expResult, result);

    }

    /**
     * Test of getActorsByName method, of class ActorRepository.
     */
    @Test
    public void testGetActorsByName() throws NullNameException {
        System.out.println("getActorsByName");
        String name = "tst4";
        Float heigth = Float.parseFloat("1.88");
        String birth = "20 July 1999";
        ActorRepository instance = new ActorRepository();
        instance.insertNewActor(name, heigth, birth);
        Actor expResult = new Actor(name, 1, heigth, birth);

        List<Actor> result = instance.getActorsByName(name);
        assertEquals(expResult, result.get(0));

    }

    /**
     * Test of getAllActors method, of class ActorRepository.
     */
    @Test
    public void testGetAllActors() {

    }

    /**
     * Test of loadFromTxtFile method, of class ActorRepository.
     */
    @Test
    public void testLoadFromTxtFile() throws Exception {

    }

    /**
     * Test of SaveAsTxtFile method, of class ActorRepository.
     */
    @Test
    public void testSaveAsTxtFile() throws Exception {

    }

    /**
     * Test of updateActor method, of class ActorRepository.
     */
    @Test
    public void testUpdateActor() {

    }
    
}
