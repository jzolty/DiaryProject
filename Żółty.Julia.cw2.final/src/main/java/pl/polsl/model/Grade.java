/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import java.util.ArrayList;

/**
 * Class that represents a student's grade. Its storying the activities(e.g.
 * spr,egz,kartk,odp) of a student. It calculates the grade's weight based on
 * the type of activity.
 *
 * @author Julia Zolty
 * @version 1.1
 */
public class Grade {

    private float grade; // The numeric grade assigned to the activity
    private ActivityBase activity; // The specific activity associated with this grade

    private ArrayList<ActivityBase> activities = new ArrayList<>(); // List to store activities

    /**
     * Constructs a Grade object with a specified grade and activity type.
     *
     * @param g the grade of the student
     * @param activityType the type of activity associated with the grade
     */
    public Grade(float g, String activityType) {
        this.grade = g;
        setActivity(activityType);
        activities.add(activity);
    }

    /**
     * Sets the activity based on the provided activity type.
     *
     * @param activityType the type of activity (e.g., "quiz", "exam", etc.)
     */
    public void setActivity(String activityType) {
        switch (activityType.toLowerCase()) {
            case "quiz":
                this.activity = new ActivityBase.QuizActivity();
                break;
            case "exam":
                this.activity = new ActivityBase.ExamActivity();
                break;
            case "oral exam":
                this.activity = new ActivityBase.OralExamActivity();
                break;
            case "act":
                this.activity = new ActivityBase.ActActivity();
                break;
            default:
                this.activity = new ActivityBase.OtherActivity();
                break;
        }
    }

    /**
     * Returns the weight of the current activity.
     *
     * @return the weight of the activity as a float
     */
    public float getWage() {
        return this.activity.getWage();
    }

    /**
     * Returns the grade assigned to this Grade object.
     *
     * @return the grade of the student as a float
     */
    public float getGrade() {
        return this.grade;
    }

    /**
     * Returns the list of activities associated with this Grade object.
     *
     * @return an ArrayList of ActivityBase representing the activities
     */
    public ArrayList<ActivityBase> getActivities() {
        return this.activities;
    }

    /**
     * Default constructor for Grade class. This constructor allows for the
     * creation of a Grade object without initial values.
     */
    public Grade() {
    }

    ;
   
   
    /**
    * Method that sets grade of an Grade object
    * @param g grade of the student 
    */ 
    public void setGrade(float g) {
        this.grade = g;
    }

}
