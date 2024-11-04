/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

/**
 * Custom exception class to handle invalid grade inputs. This exception is
 * thrown when the grade input is not within the valid range (1.0 to 5.0).
 *
 * @author Julia
 * @version 1.1
 */
public class GradeInputException extends Exception {

    /**
     * Default constructor that displays a predefined message when the exception
     * is thrown.
     */
    public GradeInputException() {
        super("Invalid grade input! It has to be in 1.0 to 5.0 range");
    }

}
