package Week2;
/**
 * A class is a blueprint for a something we can model and create variables to use in our code
 * This code (class) what a student is 
 */
public class Student {

/**
 * Attributes that define a student
 * The state of a specific student is what is in the attribute at a specifi point
 */

  private String name;
  private String studentNumber;
  private int grade;
  private int totalMarks;
  private int numMarks;
  private double average;

  /**
   * The method with the same names as the class is used to instantiate (create) a student object
   * 
   * Contructor - purpose is to instantiate an instance of a class and places it in its initial stance
   */
  public Student(String name, String studentNumber, int grade) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.grade = grade;
    this.totalMarks = 0;
    this.numMarks = 0;
    this.average = 0;
  }
/**
 * displayName, displayStudentNumber, display Grade
 * The methods (actions) in a class define behaviour for the class
 */
  public void displayName() {
    System.out.println(name);
  }

  public String getName(){
    return name;
  }
/**
 *A void method performs a task and does not return a value
 */
  public void displayStudentNumber() {
    System.out.println(studentNumber);
  }
  /**
   * non static methods do not have the word static before the return type
   * non static methods and attributes mean the methods attribute belongs to the object - not the class
   * Every instance gets its own version
   */

  public void increaseGrade() {
    grade++;
  }

  public void displayGrade() {
    System.out.println(grade);
  }
  //naming method convention is the same for variables - camelCase
  public void displayAverage(){
    System.out.println(average);
  }

  public double getAverage(){
    return average;
  }

  public void addTest(int mark){
    totalMarks += mark;
    numMarks++;
    calculateAverage();
  }

  private void calculateAverage(){
    average = (double)totalMarks/numMarks;
  }

}
