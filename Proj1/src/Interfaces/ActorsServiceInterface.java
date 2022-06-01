/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Actor;
import java.util.List;

/**
 *
 * @author gabriel.p.sousa
 */
public interface ActorsServiceInterface {
    public void insertNewActor(String name, Float heigth, String birth);
    
    public Actor findActorById(Integer id);
    
    public List<Actor> finActorByName(String name);
    
    public boolean loadFromTxtFile(String path);
    
    public void saveAsTxtFile(String path);
    
    public List<Actor> getAllActors();
    
    public boolean updateActor(Integer id, String name , String birth, Float height) ;

}
