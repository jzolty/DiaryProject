/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import java.util.ArrayList;

/**
 * Class that represents a subject. It stores information about the subject name
 * and the students enrolled in it.
 *
 * @author Julia Zolty
 * @version 1.1
 */
public class Subject {

    /**
     * Represents the name of the subject
     */
    private String subjectName;

    /**
     * ArrayList for storing Student objects associated with the subject.
     */
    private ArrayList<Student> students = new ArrayList<>(20);

    //methods
    /**
     * Constructor with one parameter to initialize the subject with a name.
     *
     * @param subjName name of the subject
     */
    public Subject(String subjName) {
        this.subjectName = subjName;

    }

    /**
     * Default constructor to create an empty Subject object.
     */
    public Subject() {
    }

    ;
    
  
    /**
     * Adds a Student object to the students ArrayList for this subject.
     * @param stud Student object 
     */
    public void addStudent(Student stud) {
        students.add(stud);
    }

    /**
     * Sets the name of the subject.
     *
     * @param subName name of the subject
     */
    public void setSubjectName(String subName) {
        this.subjectName = subName;
    }

    /**
     * Returns the name of the subject.
     *
     * @return name of the subject
     */
    public String getSubName() {
        return this.subjectName;
    }

    /**
     * Returns the ArrayList of Student objects associated with the subject.
     *
     * @return name of the subject
     */
    public ArrayList<Student> getStudents() {
        return this.students;
    }
}
