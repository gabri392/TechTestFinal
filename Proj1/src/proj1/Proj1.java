/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj1;

import Controllers.ActorController;
import Model.Actor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabriel.p.sousa
 */
public class Proj1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ActorController controller = new ActorController();
        Integer func = 20;
        System.out.println("##################################");
        System.out.println("##############WELCOME!############");
        System.out.println("##################################");
        
        while(func!=0){
            System.out.println("\n\n################################");
            System.out.println("1 - Get All Actors.");
            System.out.println("2 - Create a new Actor.");
            System.out.println("3 - Update a Actor.");
            //System.out.println("4 - Delete a Actor.");
            System.out.println("5 - Get Actor by name.");
            System.out.println("6 - Get Actor by Id.");
            System.out.println("7 - Load Actors from txt file");
            System.out.println("8 - Save Actors as txt file");
            System.out.println("9 - Exit application");
            
            String option = "";
            Scanner in = new Scanner(System.in);
            System.out.println("Please select a number between 1 and 9:");
            option = in.nextLine(); 
            
            try{
                func = Integer.parseInt(option);
            }catch(Exception ex){
                System.out.println("Wrong number inserted!");
            }
            
            if(func>0 && func<=9){
                switch(func) {
                    case 1:
                        List<Actor>  allActors = controller.getAllActors();
                        if(!allActors.isEmpty()){
                            System.out.println("\n\nList of all actors:");
                            for(Actor a:allActors){
                                System.out.println( a.toString());
                            }
                        }else{
                            System.out.println("Dont exist any Actor|");
                        }
                        break;
                    case 2:
                        //Name
                        String nameNewActor = "";
                        System.out.println("Name:");
                        nameNewActor = in.nextLine(); 
                        //heigth
                        String heigthNewActor = "";
                        System.out.println("Heigt (xx.xx(m)):");
                        heigthNewActor = in.nextLine(); 
                        //birth
                        String birthhNewActor = "";
                        System.out.println("birth :");
                        birthhNewActor = in.nextLine(); 
                        try{
                            controller.insertNewActor(nameNewActor, Float.parseFloat(heigthNewActor), birthhNewActor);
                        }catch(NullPointerException e){
                            System.out.println("Cant insert a empty name!" );
                        }catch(Exception ex){
                            System.out.println("Error in provided data: " );
                        }
                      break;
                    case 3:
                        List<Actor>  allActorsToUpdate = controller.getAllActors();
                        if(!allActorsToUpdate.isEmpty()){
                            System.out.println("\n\nList of all actors:");
                            for(Actor a:allActorsToUpdate){
                                System.out.println( a.toString());
                            }
                        }else{
                            System.out.println("Dont exist any Actor|");
                        }
                        String idToUpdate = "";
                        System.out.println("Insert actorId to update:");
                        idToUpdate = in.nextLine(); 
                        //Name
                        String nameToUpdate = "";
                        System.out.println("New Name:");
                        nameToUpdate = in.nextLine(); 
                        //heigth
                        String heigthToUpdate = "";
                        System.out.println("Heigt (xx.xx(m)):");
                        heigthToUpdate = in.nextLine(); 
                        //birth
                        String birthToUpdate = "";
                        System.out.println("birth :");
                        birthToUpdate = in.nextLine(); 
                        try{
                             if(controller.updateActor(Integer.parseInt(idToUpdate), nameToUpdate, birthToUpdate, Float.parseFloat(heigthToUpdate))){
                                 System.out.println("Actor updated! " );
                             }else{
                                  System.out.println("Error! Id provided dont found!" );
                             }
                        }catch(Exception ex){
                            System.out.println("Error in provided data: " );
                        }
                       
                      break;
                    case 4:
                        System.out.println("Not implemented yet!"); 
                      break;
                    case 5:
                        String nameToFind = "";
                        System.out.println("Name:");
                        nameToFind = in.nextLine(); 
                        
                        List<Actor> actorsFound = controller.finActorByName(nameToFind);
                        if(!actorsFound.isEmpty()){
                            for(Actor actor:actorsFound){
                                System.out.println("Actor found: " + actor.toString());
                            }
                        }else{
                            System.out.println("Dont foun any actor whit name: " + nameToFind);
                        }
                      break;
                    case 6:
                        String idToFind = "";
                        System.out.println("Id:");
                        idToFind = in.nextLine(); 
                        
                        Actor actorFound = controller.findActorById(Integer.parseInt(idToFind));
                        if(actorFound!=null){
                                System.out.println("Actor found: " + actorFound.toString());
                        }else{
                            System.out.println("Dont foun any actor whit Id: " + idToFind);
                        }
                      break;
                    case 7:
                        String path = "";
                        System.out.println("\n\nGive the correct path of txt data file: ");
                        path = in.nextLine();       
                        System.out.println("You give the path: " + path);
                        controller.loadFromTxtFile(path);
                      break;
                    case 8:
                        String pathToSave = "";
                        System.out.println("\n\nGive the path to save the file: ");
                        pathToSave = in.nextLine();       
                        controller.saveAsTxtFile(pathToSave);
                        System.out.println("File created: " + pathToSave);
                      break;
                    case 9:
                      func = 0;
                      break;
                    default:
                      // code block
                }
            }else{
                func = 20;
                System.out.println("Wrong number inserted!");
            }
        }
        
        
        
        
        
        
        
    }
    
}
