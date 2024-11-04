/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

/**
 * Class that represents a base for different types of activities. This abstract
 * class provides a common structure for all specific activity types, including
 * their associated weights.
 *
 * @author Julia Zolty
 * @version 1.1
 */
public abstract class ActivityBase {

    /**
     * Weight assigned to a specific activity. The weight is a floating-point
     * number that represents the importance or value of the activity in the
     * overall grading scheme.
     */
    protected float wage;

    /**
     * Returns the weight of the activity.
     *
     * @return weight of the activity as a float
     */
    public float getWage() {
        return this.wage;
    }

    /**
     * Class representing a Quiz activity. This class extends ActivityBase and
     * initializes the weight specific to quiz activities.
     */
    public static class QuizActivity extends ActivityBase {

        public QuizActivity() {
            this.wage = 0.8f;
        }

        @Override
        public String toString() {
            return "Quiz";
        }
    }

    /**
     * Class representing an Exam activity. This class extends ActivityBase and
     * initializes the weight specific to exam activities.
     */
    public static class ExamActivity extends ActivityBase {

        public ExamActivity() {
            this.wage = 1.0f;
        }

        @Override
        public String toString() {
            return "Exam";
        }
    }

    /**
     * Class representing an Oral Exam activity. This class extends ActivityBase
     * and initializes the weight specific to oral exam activities.
     */
    public static class OralExamActivity extends ActivityBase {

        public OralExamActivity() {
            this.wage = 0.7f;
        }

        @Override
        public String toString() {
            return "Oral Exam";
        }
    }

    /**
     * Class representing an Activity. This class extends ActivityBase and
     * initializes the weight specific to general activity types.
     */
    public static class ActActivity extends ActivityBase {

        public ActActivity() {
            this.wage = 0.5f;
        }

        @Override
        public String toString() {
            return "Activity";
        }
    }

    /**
     * Class representing another type of activity. This class extends
     * ActivityBase and initializes the weight specific to miscellaneous
     * activities.
     */
    public static class OtherActivity extends ActivityBase {

        public OtherActivity() {
            this.wage = 1.0f;
        }

        @Override
        public String toString() {
            return "Other";
        }
    }
}
