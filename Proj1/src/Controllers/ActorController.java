/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Exceptions.NullBirthException;
import Exceptions.NullNameException;
import Interfaces.ActorsServiceInterface;
import Model.Actor;
import Repositories.ActorRepository;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.p.sousa
 */
public class ActorController implements ActorsServiceInterface{
    
    private ActorRepository db;

    public ActorController() {
        this.db = new ActorRepository();
    }
    
    public void insertNewActor(String name, Float heigth, String birth) {
        try {
            db.insertNewActor(name, heigth, birth);
        } catch (NullNameException e) {
            System.out.println("Cant insert a empty name!!" );
        } catch (NullBirthException ex) {
            System.out.println("Cant insert a empty birth!!" );
        }
    }
    
    public Actor findActorById(Integer id) {       
        return db.getActorById(id);
    }
    
    public List<Actor> finActorByName(String name) {       
        return db.getActorsByName(name);
    }
    
    public boolean loadFromTxtFile(String path)  {       
        try {
            return db.loadFromTxtFile(path);
        } catch (IOException ex) {
            Logger.getLogger(ActorController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public void saveAsTxtFile(String path)  {       
        try {
            db.SaveAsTxtFile(path);
        } catch (IOException ex) {
            Logger.getLogger(ActorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Actor> getAllActors() {       
        return db.getAllActors();
    }
    
    @Override
    public boolean updateActor(Integer id, String name , String birth, Float height) { 
        Actor toUpdate = new Actor(name, id, height, birth);
        return db.updateActor(toUpdate);
    }
    

}
