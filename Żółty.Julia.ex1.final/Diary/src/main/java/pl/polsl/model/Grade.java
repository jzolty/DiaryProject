/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;
import java.util.ArrayList;

/**
 * Class that represents a student's grade. Its storying the activities(e.g. spr,egz,kartk,odp) of a student.
 * It calculates the grade's weight based on the type of activity.
 * @author Julia Zolty
 * @version 1.0
 */
public class Grade {
  
    
    /**
    * represent a grade of a student 
    */
   private float grade;
   
    /**
    * represent a wage. Its used for calculating a grade
    */
   private float wage;

   
    /* 
    * enum that represents type of activity of the student 
    */
   public enum Activity{
       QUIZ,
       EXAM,
       ORALEXAM,
       ACT,
       OTHER
   }
    /**
     * represent the activity of the student
     */
   private Activity act;
   
   
   //methods
   
   /**
     * Method that set the activity of the student and wage of the grade
     * @param nameOfAct name of the activity as a string
     */
   private void setActivity(String nameOfAct){
       if(nameOfAct.equals("quiz")){
          this.act = Activity.QUIZ;
          this.wage = (float) 0.8;
       }
       else if(nameOfAct.equals("oral exam")){
           this.act = Activity.ORALEXAM;
           this.wage = (float)0.7;
       }
       else if(nameOfAct.equals("exam")){
           this.act = Activity.EXAM;
           this.wage = (float)1.0;
       }
       else if(nameOfAct.equals("act")){
           this.act = Activity.ACT;
           this.wage = (float)0.5;
       }
       else
       {
           this.act = Activity.OTHER;
           this.wage = 1;
       }
       
}
   
   /**
     * An ArrayList that stores activites which are the string value.
     */
   private ArrayList<Activity> activities = new ArrayList<>();
   
   /**
     * class constructor with 2 parameters. Its calculating the wage of a grade
     * based on activity of a student
     * @param g grade of a student
     * @param nameOfAct activity of a student
     */           
   public Grade(float g, String nameOfAct){
       
       this.grade = g;
       setActivity(nameOfAct);
       activities.add(act);
       
       
   }
    /**
     * defualt class constructor
     */ 
   public Grade(){};
   
   
    /**
    * Method that sets grade of an Grade object
    * @param g grade of the student 
    */ 
    public void setGrade(float g){
        this.grade = g;
    }
   
    /**
    * Method that returns the grade in float number
    * @return grade in float type
    */ 
    public float getGrade(){
        return this.grade;
    }

    /**
    * Method that returns the wage of the grade
    * @return wage of the grade
    */ 
    public float getWage(){
        return this.wage;
    }

    /**
    * Method that returns the ArrayList of the activites
    * @return ArrayList of the activites
    */ 
    public ArrayList<Activity> getActivities(){
        return this.activities;
    }
 
}