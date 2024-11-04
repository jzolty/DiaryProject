/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;
import java.util.ArrayList;

/**
 * Class that represents student. It stores information about the student
 * and their grades.
 * @author Julia Zolty
 * @version 1.0
 */
public class Student {
    //fields
    
    /**
     * Represents the first name of the student
     */
   private String name;
   
   /**
     * Represent the lastname of the student
     */
   private String lastName;
   
   /**
     * An ArrayList that stores Grade objects  of the student
     */
   public ArrayList<Grade> grades = new ArrayList<>(20);
   
   /**
     * Represent average grade of the student 
     */
   public float average;
    
    //methods 
   
   /**
     * Constructor with two parameters to initialize the student's name and last name.
     * @param n name of the student
     * @param lname lastname of the student
     */
    public Student(String n, String lname){
        
        this.name = n;
        this.lastName =lname;
       
    }
    
    /**
     *  Default constructor to create an empty Student object.
     */
    public Student(){};
    
    /**
    * Method that adds data about the student, including their name, last name,
    * subject, activity, and grade. It throws an exception if the grade is invalid.
    * 
    * @param name the first name of the student.
    * @param lname the last name of the student.
    * @param sbj the name of the subject.
    * @param act the type of activity (e.g., "kartk", "egz").
    * @param g the grade of the student for the activity.
    * @throws GradeInputException if the grade is not between 1.0 and 5.0.
    */
   public void addData(String name, String lname, String sbj, String act, float g) throws GradeInputException {
    if (g < 1.0 || g > 5.0) {
        throw new GradeInputException();  // Throws exception for invalid grade
    }
    }

    /**
     * Adds a Grade object to the ArrayList of grades for the student.
     * 
     * @param grade the Grade object to be added.
     */
   public void addGrade(Grade grade) {
        grades.add(grade);
    }
    
    /**
     * Sets the first name of the student.
     * @param name student name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Returns the first name of the student.
     * @return the name of the student
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Sets the last name of the student.
     * @param lname student lastname
     */
    public void setLastName(String lname){
        this.lastName = lname;
    }
    
    /**
     * Returns the last name of the student.
     * @return last name of the student 
     */
    public String getLastName(){
        return this.lastName;
    }
    
    /**
     * Calculates the average grade of the student based on the ArrayList of grades.
     * The average is calculated as the weighted sum of grades.
     * @param g ArrayList of grades
     */
    public void calcAvg(ArrayList<Grade> g){
        float sum = 0;
        
        for(Grade grad : g){
           sum+= grad.getGrade() * grad.getWage();
        }
  
        this.average = sum/g.size();
        this.average *=100;
        this.average = Math.round(this.average);
        this.average /=100;
       
    
    }

    
}