package Week2;

public class StudentExample {
    public static void main(String[] args) {
        Student shohei;
        shohei = new Student("Shohei", "12946", 11);
        //Shohei is a student (object variable) and has been brought to life by the power of vscode
        Student samantha = new Student("Samantha", "18471", 11);
        Student alan = shohei;
        //called the method increaseGrade(), because alan and shohei reference the same student object,
        //they are the same increase in grade and are both in grade 12
        alan.increaseGrade();
        //we activate methods through the object (e.g. alan.WhateverThisFunctionIs
        samantha.displayName();
        samantha.displayStudentNumber();
        samantha.increaseGrade();
        samantha = null;
        /**
         * cannot call a reference from a null object
         */

        alan = new Student("Alan", "55555", 11);
        alan.addTest(87);
        alan.displayAverage();
        alan.addTest(92);
        alan.displayAverage();
        alan.addTest(96);
        alan.displayAverage();
        alan.addTest(67);
        alan.displayAverage();
        //alan.numMarks = 7; dont have access to private stuff
    }
}
