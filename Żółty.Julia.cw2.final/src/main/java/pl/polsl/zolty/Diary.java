package pl.polsl.zolty;

import pl.polsl.controller.Controller;
import pl.polsl.model.Register;
import pl.polsl.view.RegisterView;
import pl.polsl.gui.MainMenuFrame;

import java.util.Scanner;
import pl.polsl.model.Subject;

/**
 * Main class of the application responsible for the user interface and handling
 * command-line parameters.
 *
 * This application allows for managing student grades, including adding
 * records, displaying subjects, and showing a student's diary.
 *
 * The application initializes the model, view, and controller components,
 * processes command-line arguments for adding data, and launches the GUI.
 *
 * @author Julia Zolty
 * @version 1.1
 */
public class Diary {

    /**
     * The entry point of the application. This method initializes the model,
     * view, and controller, processes command-line arguments, and displays the
     * main menu.
     *
     * @param args command-line arguments passed to the application. Expected to
     * include student data for addition to the register.
     */
    public static void main(String[] args) {

        RegisterView view = new RegisterView(); //creating view
        Register model = new Register("Group 5"); // creating model
        Controller controler = new Controller(model, view); // creating controller
        if (controler.checkInputOfData(args) == 1) {

            System.out.println("Parameters are correct");
            controler.addData(args[0], args[1], args[2], args[3], Float.parseFloat(args[4]));
        }

        // If parameters are correct or partially correct, launch the GUI
        if (controler.checkInputOfData(args) == 1 || controler.checkInputOfData(args) == 2) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    // Create and display the main menu frame
                    new MainMenuFrame(model, controler).setVisible(true);
                }
            });

        }

    }

}
