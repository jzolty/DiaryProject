/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

import pl.polsl.model.Register;

/**
 * View class in MVC pattern. Used for displaying the data.
 *
 * @author Julia Zolty
 * @version 1.1
 */
public class RegisterView {

    /**
     * Method that displays the subjects available in the register. If no
     * subjects are available, it informs the user.
     *
     * @param d Diary object
     */
    //TODO
    public void showSubjects(Register d) {
        if (d.getSubjects().isEmpty()) {
            System.out.println("No subject exist.");
            return; // Jeśli brak przedmiotów, zakończ metodę
        }

        for (int i = 0; i < d.getSubjects().size(); i++) {
            System.out.println((i + 1) + "." + d.getSubjects().get(i).getSubName());
        }

    }

    /**
     * Method that displays the details of the diary, including subjects,
     * students, and their grades.
     *
     * @param d Register object representing the diary
     */
    public void showDiary(Register d) {
        System.out.println("Class name: " + d.getClassName());
        System.out.println("************************");
        for (int i = 0; i < d.getSubjects().size(); i++) {
            System.out.println("Subject: " + d.getSubjects().get(i).getSubName());
            //printing students
            for (int j = 0; j < d.getSubjects().get(i).getStudents().size(); j++) {
                System.out.print((j + 1) + ". " + d.getSubjects().get(i).getStudents().get(j).getName() + " "
                        + d.getSubjects().get(i).getStudents().get(j).getLastName() + " ");

                //printing grades
                for (int k = 0; k < d.getSubjects().get(i).getStudents().get(j).grades.size(); k++) {
                    System.out.print("Grade: " + d.getSubjects().get(i).getStudents().get(j).grades.get(k).getGrade() + " ");
                }
                System.out.print("Average: " + d.getSubjects().get(i).getStudents().get(j).average + "\n");
            }
        }
    }

    /**
     * Method that display the interface
     *
     */
    public void showInterface() {
        System.out.println("******************************************************");
        System.out.println("Enter the number to make decsion: ");
        System.out.println("1.Add new record to database");
        System.out.println("2.Add a student to an existing subject ");
        System.out.println("3. Show diary");
        System.out.println("4.Show existing subjects");
        System.out.println("5.Exit ");
        System.out.print("Please enter your choice: ");

    }

}
