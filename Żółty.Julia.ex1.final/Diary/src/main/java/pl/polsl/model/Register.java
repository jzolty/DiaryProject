/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;
import java.util.ArrayList;
import pl.polsl.model.GradeInputException;


/**
* 
* Class representing a Register, which stores information about subjects 
 * and students in a class. Each subject has its own list of students. 
* 
* @author  Julia Zolty
* @version 1.0
*/
public class Register {
    
    
    //TODO className
    /**
     * Represent class name for a register
     */
    private String className;   
    
     /**
     * ArrayList for storaging subject objects
     */
    private ArrayList<Subject> subjects = new ArrayList<>(20);

    
    
   //constructors
    /**
     * Constructor with a parameter to initialize a register with a class name.
     *
     * @param c_name name of a class as String
     */
    public Register(String c_name){
        this.className=c_name;
    }
    
     /**
     *  Default constructor to create an empty Register object.
     */
    public Register(){};
    
    //methods
    
    
    /**
     * Method for setting a class name for an register object
     * @param name name of a class as String
     */
    public void setClassName(String name){
        this.className = name;
    }
    
    /**
     * Method for checking if an subject ArrayList is empty 
     * @return true, if array is empty else false
     */
    public boolean isEmpty(){
       return this.getSubjects().isEmpty();
        
    }
    
    /**
     * Method that returns size of an array
     * @return size of an array in int type
     */
    public int getSize(){
        return this.subjects.size();
    }
    
    /**
     * Method that returns the class name of an register object
     * @return class name of an object as a String
     */
    public String getClassName(){
    return this.className;
    }
    
    /**
     * Method that adds Subject object to an subjects ArrayList
     * @param subject a Subject object to be added to the list. 
     */
    public void addSubject(Subject subject){
            subjects.add(subject);
    }

    /**
     * Returns the list of subjects in the register
     * @return ArrayList of Subject objects
     */
    public ArrayList<Subject> getSubjects(){
        return subjects;
    } 
    
    
    /**
     *Returns an array containing the names of all subjects in the register
     * @return a String array with the names of the subjects
     */
    public String[] getSubjectsName(){
    String[] names  = new String[subjects.size()];
    
    for(int i =0; i<subjects.size(); i++){
       names[i] = (subjects.get(i).getSubName());
       
    }
    return names;
    }
    
    /**
     * Adds a student to a subject by the subject's index in the list. 
     * If the student already exists, it adds a grade to the existing student. 
     * Otherwise, a new student is created.
     * @param index value that is used to find elements in an subject ArrayList
     * @param name name of the student
     * @param lname name of the student
     * @param act activity of the student
     * @param g grade of the student
     */        

    public void addStudentToSubject(int index, String name, String lname, String act, float g) {
    Subject subject = this.subjects.get(index);
    
     // Check if the student already exists
    Student existingStudent = null;
    for (Student student : subject.getStudents()) {
        if (student.getName().equals(name) && student.getLastName().equals(lname)) {
            existingStudent = student;
            break;
        }
    }
    
    Grade grd = new Grade(g, act);
    
    if (existingStudent != null) {
        // If the student exists, add the grade
        existingStudent.addGrade(grd);
        existingStudent.calcAvg(existingStudent.grades);
    } else {
         // If the student doesn't exist, create a new one
        Student newStudent = new Student(name, lname);
        newStudent.addGrade(grd);
        newStudent.calcAvg(newStudent.grades);
        subject.addStudent(newStudent);
    }
    }
    
     /**
     * Adds data to the Register object by creating or updating a student in 
     * the relevant subject. If the subject or student doesn't exist, they are created.
     * Throws an exception if the grade is outside the valid range.
     * 
     * @param name  first name of the student.
     * @param lname  last name of the student.
     * @param sbj  name of the subject.
     * @param act  activity type.
     * @param g  grade of the student.
     * @throws GradeInputException if the grade is not between 1.0 and 5.0.
     */
    
    public void addData(String name, String lname, String sbj, String act, float g) throws GradeInputException {
    // Check if the grade is within the valid range
    if (g < 1.0 || g > 5.0) {
        throw new GradeInputException();  // Throw exception for invalid grades
    }

    // Check if the subject already exists
    Subject subj = null;
    for (Subject subject : subjects) {
        if (subject.getSubName().equals(sbj)) {
            subj = subject;
            break;
        }
    }

    // If the subject doesn't exist, create it
    if (subj == null) {
        subj = new Subject(sbj);
        this.addSubject(subj);
    }

    // Check if the student already exists
    Student existingStudent = null;
    for (Student student : subj.getStudents()) {
        if (student.getName().equals(name) && student.getLastName().equals(lname)) {
            existingStudent = student;
            break;
        }
    }

    Grade grd = new Grade(g, act);
    
    if (existingStudent != null) {
        // If the student exists, add the grade
        existingStudent.addGrade(grd);
        existingStudent.calcAvg(existingStudent.grades);
    } else {
        // If the student doesn't exist, create a new one
        Student newStudent = new Student(name, lname);
        newStudent.addGrade(grd);
        newStudent.calcAvg(newStudent.grades);
        subj.addStudent(newStudent);
    }
    }
    
    /**
     * Returns the total number of students across all subjects in the register.
     * @return the total number of students.
     */
    public int getNumberOfStudents(){
        int sum =0;
        for(int i = 0; i<this.subjects.size(); i++){
            
           for(int j=0; j<this.getSubjects().get(i).getStudents().size();j++){
               
               sum+=1;
           }
        }
        return sum;
    }
     
    /**
     * Returns the total number of subjects in the register.
     * @return the number of subjects
     */
    public int getSizeOfSubjects() {
        return this.subjects.size();
    }

}

