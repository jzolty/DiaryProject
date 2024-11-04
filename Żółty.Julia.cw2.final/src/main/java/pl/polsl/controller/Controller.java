/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.controller;

import pl.polsl.model.Register;
import pl.polsl.model.Subject;
import pl.polsl.view.RegisterView;
import pl.polsl.model.GradeInputException;

/**
 *
 * Controller class in MVC pattern. It manages the flow of data into the
 * Register object. This class maintains separation between the view and the
 * register model.
 *
 * @author Julia Zolty
 * @version 1.1
 */
public class Controller {

    /**
     * Represent register model
     */
    private Register model;

    /**
     * Represent register view
     */
    private RegisterView view;

    //methods
    /**
     * class Constructs a Controller with the specified Register and
     * RegisterView objects.
     *
     * @param d Register object representing the data model
     * @param dw RegisterView object representing the user interface
     */
    public Controller(Register d, RegisterView dw) {
        this.model = d;
        this.view = dw;

    }

    /**
     * Method that adds a subject to the register's subject list.
     *
     * @param sub Subject object to be added to the register
     */
    public void addToRegister(Subject sub) {
        model.addSubject(sub);
    }

    /**
     * Adds a student to an existing subject in the register.
     *
     * @param subjectIndex Index of the subject in the register.
     * @param name First name of the student.
     * @param lname Last name of the student.
     * @param activity Name of the activity for the student.
     * @param grade Grade of the student.
     */
    public void addStudentToSubject(int subjectIndex, String name, String lname, String activity, float grade) {
        // Sprawdź, czy index przedmiotu jest poprawny
        if (subjectIndex >= 0 && subjectIndex < model.getSizeOfSubjects()) {
            // Dodaj studenta do przedmiotu z podaną aktywnością i oceną
            model.addStudentToSubject(subjectIndex, name, lname, activity, grade);
            System.out.println("Student " + name + " " + lname + " has been added to the subject at index " + subjectIndex + ".");
        } else {
            System.out.println("Subject at index " + subjectIndex + " does not exist.");
        }
    }

    /**
     * Method for updating if subjects list in the register is empty
     *
     * @return True, if array is empty else false
     */
    public boolean isSubjectsEmpty() {
        return this.model.isEmpty();

    }

    /**
     * Method that returns the ArrayList with Subject names
     *
     * @return ArrayList of Subject names
     */
    public String[] getSubNames() {
        return this.model.getSubjectsName();
    }

    /**
     * Method that returns size of an array
     *
     * @return Size of an array in int type
     */
    public int getSizeOfSubjects() {
        return this.model.getSize();
    }

    /**
     * Method that update the view of the diary object.
     *
     * @param d Register object to be displayed in the view
     */
    public void updateRegisterView(Register d) {
        this.view.showDiary(this.model);
    }

    /**
     * Method that update the view of the interface
     *
     */
    public void updateShowInterface() {
        this.view.showInterface();
    }

    /**
     * Method that update the view of the subject object.
     *
     * @param d register object
     */
    public void updateSubjectView(Register d) {
        this.view.showSubjects(this.model);
    }

    /**
     * Method that returns the class name of an Diary object
     *
     * @return class name of an object as a String
     */
    public String getClassName() {
        return this.model.getClassName();
    }

    /**
     * Method that updates data, adding data to Diary object.
     *
     * @param name first name of the student
     * @param lname last name of the student
     * @param sbj name of the subject
     * @param act activity of the student
     * @param g grade of student
     */
    public void addData(String name, String lname, String sbj, String act, float g) {
        try {
            this.model.addData(name, lname, sbj, act, g); // Call the method that may throw GradeInputException
        } catch (GradeInputException e) {
            System.out.println(e.getMessage());  // Handle exception if grade is invalid
        }
    }

    /**
     * Method that validates input data from the command line.
     *
     * @param args command line arguments where: first arg - name of the
     * student(string), second arg - lastname of the student(string), third arg
     * - name of the subject(string), fourth arg - name of the activity(string),
     * fifth arg - grade of the student(int number)(only this numbers user can
     * pass 2-5)
     * @return 1 if parameters are correct, 0 if parameters are not correct, 2
     * if there are no parameters or not enough of them
     */
    //TODO
    public int checkInputOfData(String args[]) {

        int numberOfParameters = args.length;
        int flag = 1;

        if (numberOfParameters == 5) {
            if (args[0].matches("[a-zA-Z]+") && args[1].matches("[a-zA-Z]+")
                    && args[2].matches("[a-zA-Z]+")
                    && args[3].matches("^[a-zA-Z0-9]+$")) {

                if (args[4].matches("[+-]?([1-5]*[.])?[1-5]+")) {

                    //System.out.println("Parameters are correct");
                    flag = 1;

                } else {
                    System.out.println("Last parameter is not correct");
                    flag = 0;
                }

            } else {
                System.out.println("The first 4 parameters must be a string value. Try again. ");
                flag = 0;
            }

        } else if (numberOfParameters > 0 && numberOfParameters > 5) {
            //System.out.println("Not enough parameters");
            flag = 2;

        } else {
            // System.out.println("No parameters"); 
            flag = 2;

        }

        return flag;
    }

    /**
     * Method that checks data input if user is using main program. It refers to
     * checking input if user is adding a record in database
     *
     * @param name name of the student
     * @param lname lastname of the student
     * @param sbj name of the subject
     * @param act name of the activity
     * @param g grade of the student in string type
     * @return true if input is correct; false otherwise
     */
    public boolean checkInputOfData(String name, String lname, String sbj, String act, String g) {
        if (name.matches("[a-zA-Z]+") && lname.matches("[a-zA-Z]+")
                && sbj.matches("[a-zA-Z]+")
                && act.matches("^[a-zA-Z0-9]+$")
                && g.matches("[+-]?([1-5]*[.])?[1-5]+")) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Method that checks data input if user is using main program. It refers to
     * checking input if user wants to add a student to existing subject
     *
     * @param name name of the student
     * @param lname lastname of the student
     * @param act name of the activity
     * @param g grade of the student in string type
     * @return true if input is correct; false otherwise
     */
    public boolean checkInputOfStudent(String name, String lname, String act, String g) {
        if (name.matches("[a-zA-Z]+") && lname.matches("[a-zA-Z]+")
                && act.matches("^[a-zA-Z0-9]+$")
                && g.matches("[+-]?([1-5]*[.])?[1-5]+")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that returns the number of all students
     *
     * @return amount of all students
     */
    public int getNumberOfStudents() {
        return this.model.getNumberOfStudents();
    }

    /*   
     * Method that transforms the data from ArrayList to 2D Array. Its needed
     * for creating the  defualt table model used by ShowDatabaseFrame(GUI) to
     * show data in table mode. 
     * @return 2D array of data
     */
    public Object[][] addDataTo2DArray() {
        return this.model.addDataTo2DArray();
    }
}
