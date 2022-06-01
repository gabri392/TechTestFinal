/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Exceptions.NullBirthException;
import Exceptions.NullNameException;
import Model.Actor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gabriel.p.sousa
 */
public class ActorRepository {
    private ArrayList<Actor> actorsRepo;

    public ActorRepository() {
        this.actorsRepo = new ArrayList<Actor>();
    }
    
    public void insertNewActor(String name, Float heigth, String birth) throws NullNameException, NullBirthException{
        if(name == null||name.equals("")){
            throw new NullNameException();
        }
        if(birth == null||birth.equals("")){
            throw new NullBirthException();
        }
        Integer maxCurrId = getNextId();
        actorsRepo.add(new Actor( name, maxCurrId, heigth, birth ));
    }
    
    public boolean loadActor(String name, Integer id, Float heigth, String birth){
        for(Actor a:actorsRepo){
            if(a.getActorId().toString().equals(id.toString())){
                return false;
            }
        }
        actorsRepo.add(new Actor( name, id, heigth, birth ));
        return true;
    }
    
    private Integer getNextId() {
        Integer maxId = 0;
        for(Actor actor : this.actorsRepo){
            if(actor.getActorId()>maxId){
                maxId = actor.getActorId();
            }
        }
        return maxId + 1;
    }
    
    public Actor getActorById(Integer id){     
        Actor actorFound = null;
        for(Actor actor : this.actorsRepo){
            if(String.valueOf(actor.getActorId()).equals(String.valueOf(id))){
                actorFound = actor;
            }
        }
        return actorFound;
    }
    
    public List<Actor> getActorsByName(String name){     
        ArrayList<Actor> actorsFound = new ArrayList<Actor>();
        for(Actor actor : this.actorsRepo){
            if(actor.getName().equals(name)){
                actorsFound.add(actor);
            }
        }
        return actorsFound;
    }
    
    public List<Actor> getAllActors(){     
        ArrayList<Actor> actorsFound = new ArrayList<Actor>();
        for(Actor actor : this.actorsRepo){
                actorsFound.add(actor);
        }
        return actorsFound;
    }
    
    public boolean loadFromTxtFile(String path) throws FileNotFoundException, IOException{
        try{
            BufferedReader buffRead = new BufferedReader(new FileReader(path));
            String readLine = "";
            while (true) {
                    readLine = buffRead.readLine();
                    if (readLine != null) {
                            System.out.println(readLine);
                            String line[] = readLine.split(",");
                            
                            boolean status = loadActor(line[0],Integer.parseInt(line[1]), Float.parseFloat(line[2]), line[3]);
                            if(status==false){
                                System.out.println("You cant have 2 actors whit the same id. --> " + line[1] );
                            }
                    } else
                            break;
                    
            }
            buffRead.close();
            
            return true;
        }catch(Exception ex){
            System.out.println("Error: ActorRepository:loadFromTxtFile" + ex.getMessage());
            return false;
        }
    }
    
    public void SaveAsTxtFile(String path) throws IOException{
        try{
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

            for(Actor a:actorsRepo){
               String newLine = "";

               newLine = a.getName()+ "," + a.getActorId()+"," + a.getHeight() + "," + a.getBirth();          
               buffWrite.append(newLine + "\n"); 
            }

            buffWrite.close();
        }catch(Exception ex){
            System.out.println("Error: ActorRepository:SaveAsTxtFile" + ex.getMessage());

        }
    }

    public boolean updateActor(Actor updActor) {
        boolean flag = false;
        for(Actor actor : this.actorsRepo){
            if(String.valueOf(actor.getActorId()).equals(String.valueOf(updActor.getActorId()))){
                actorsRepo.remove(actor);
                actorsRepo.add(updActor);
                flag=true;
            }
        }
        
        return flag;
    }

    
}
