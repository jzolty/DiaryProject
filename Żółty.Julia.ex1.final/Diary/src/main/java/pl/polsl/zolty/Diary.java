
package pl.polsl.zolty;

import pl.polsl.controller.Controller;
import pl.polsl.model.Register;
import pl.polsl.view.RegisterView;

import java.util.Scanner;
import pl.polsl.model.Subject;

/**
* Main class of the application responsible for the user interface and handling
* command-line parameters.
* 
* This application allows for managing student grades, including adding
* records, displaying subjects, and showing a student's diary.
* 
* @author Julia Zolty
* @version 1.0
*/
public class Diary {

    /**
    * Main method of the application.
    * It handles both command-line arguments and an interactive user interface.
    * 
    * Command-line arguments:
    * 1. First argument - name of the student (String)
    * 2. Second argument - last name of the student (String)
    * 3. Third argument - subject name (String)
    * 4. Fourth argument - activity name (String) (e.g., "exam", "quiz", "act")
    * 5. Fifth argument - grade (float) (acceptable values: 1.0 to 5.0)
    * 
    * Example usage with arguments:
    * Jan Nowak Informatics egz 3.0
    * 
    * @param args command-line arguments passed to the program
    */
    public static void main(String[] args) {
        RegisterView view = new RegisterView(); // creating view
        Register model = new Register("Group 5"); // creating model
        
        //for example 
        //model.addSubject(new Subject("Math"));
       // model.addSubject(new Subject("Informatics"));
        //model.addSubject(new Subject("Chemistry"));
        
        Controller controller = new Controller(model, view); // creating controller

        // Handle command-line input
        if (args.length == 5 && controller.checkInputOfData(args) == 1) {
            System.out.println("Parameters are correct");
            controller.addData(args[0], args[1], args[2], args[3], Float.parseFloat(args[4]));
        } else if (args.length != 0) {
            System.out.println("Incorrect parameters. Please enter data in the following format:");
            System.out.println("name lastname subject activity grade");
            return; // Exit if input is not correct
        }

        // Interactive command-line interface
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            view.showInterface();  // Show options to the user
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    // Add new record to database
                    System.out.println("Enter name, lastname, subject, activity, and grade:");
                    String name = scanner.nextLine();
                    String lastname = scanner.nextLine();
                    String subject = scanner.nextLine();
                    String activity = scanner.nextLine();
                    float grade = scanner.nextFloat();
                    controller.addData(name, lastname, subject, activity, grade);
                    break;
                case 2:
                    // Add a student to an existing subject
                    System.out.println("Enter name, lastname, subject, activity, and grade:");
                    String newName = scanner.nextLine();
                    String newLastname = scanner.nextLine();
                    String newSubject = scanner.nextLine();
                    String newActivity = scanner.nextLine();
                    float newGrade = scanner.nextFloat();
                    controller.addStudentToSubject(newName, newLastname, newSubject);
                    break;
                case 3:
                    // Show database
                    view.showDiary(model);
                    break;
                case 4:
                    // Show subjects
                    view.showSubjects(model);
                    break;
                case 5:
                    // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close(); // Close the scanner
    }
}
