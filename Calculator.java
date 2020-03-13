// ---
// Program: Calculator
//
// Description: This programs prompts the user for a problem type; addition, subtraction, multiplication, or division. It then requests two numbers and 
// does the requested operation to them. Finally it asks if the user wants to complete more problems, and if not, displays a total tally of the problems
// completed.
// 
// Assumptions and Limitations: 	
// - No real numbers (integers only)
// - Input numbers and answers will fit in the range of the int data type
// - Division is integer division
// - Binary operations only (two operands)
// - Addition, subtraction, multiplication, and division are the only operations supported
// - Perfect user: all input will be correct (y or n only; integers only for operands)
// - Results are not saved
// - The user wants to do at least one problem
// ---

import java.util.Scanner;

public class CS1Calculator {

      //Constructor
      Scanner keyboard = new Scanner(System.in);
      static String answer;
      static boolean askQuestion;
      int additionNumber = 0;
      int subtractionNumber = 0;
      int multiplicationNumber = 0;
      int divisionNumber = 0;
      int totalNumber;
      
      public void printIntro() {
      //Introduction
      System.out.println("Welcome to the calculator! This program will complete math problems that you request using given numbers.");
      System.out.print("Would you like to give it a try? (y/n): ");
      answer = keyboard.nextLine();
      
      if(answer.equalsIgnoreCase("y")){
         askQuestion = true;
      }
         else{
         askQuestion = false;
      }
   }
      
      public void calculate() {
         //Selecting problem type, and calculating
         System.out.println("-----------------------------------------------------");
         System.out.println("Great! What type of problem would you like to solve?\n" + "(A)ddition\n" + "(S)ubtraction\n" 
                            + "(M)ultiplication\n" + "(D)ivision");
            
         do {
            System.out.println();
            System.out.print("Select a problem type (A/S/M/D): ");
            String problemType = keyboard.nextLine();
            
            //Addition problem
            if(problemType.equalsIgnoreCase("A")) {
               System.out.println();
               System.out.print("You chose addition!\n" + "Enter first integer: ");
               int firstNumber = keyboard.nextInt();
               System.out.print("Enter second integer: ");
               int secondNumber = keyboard.nextInt();
               keyboard.nextLine();
               
               int sum = firstNumber + secondNumber;
               System.out.println("Sum = " + sum);
               additionNumber++;
               }
               
            //Subtraction problem
            else if(problemType.equalsIgnoreCase("S")) {
               System.out.println();
               System.out.print("You chose subtraction!\n" + "Enter first integer: ");
               int firstNumber = keyboard.nextInt();
               System.out.print("Enter second integer: ");
               int secondNumber = keyboard.nextInt();
               keyboard.nextLine();
               
               int difference = firstNumber - secondNumber;
               System.out.println("Difference = " + difference);
               subtractionNumber++;
               }
               
            //Multiplication problem
            else if(problemType.equalsIgnoreCase("M")) {
               System.out.println();
               System.out.print("You chose multiplication!\n" + "Enter first integer: ");
               int firstNumber = keyboard.nextInt();
               System.out.print("Enter second integer: ");
               int secondNumber = keyboard.nextInt();
               keyboard.nextLine();
               
               int product = firstNumber * secondNumber;
               System.out.println("Product = " + product);
               multiplicationNumber++;
               }
               
            //Division problem
            else if(problemType.equalsIgnoreCase("D")) {
               System.out.println();
               System.out.print("You chose division!\n" + "Enter first integer: ");
               int firstNumber = keyboard.nextInt();
               System.out.print("Enter second integer: ");
               int secondNumber = keyboard.nextInt();
               keyboard.nextLine();
               
               int dividend = firstNumber / secondNumber;
               System.out.println("Dividend = " + dividend);
               divisionNumber++;
               }
            
            //Checking if the user wants to solve another problem
            System.out.println();
            System.out.print("Would you like to solve another problem? (y/n): ");
            answer = keyboard.nextLine();
               
            if(answer.equalsIgnoreCase("n")){
               askQuestion = false;
            }
               else{
               askQuestion = true;
            }
               
            } while(askQuestion);
         }
            
      public void printReport(){
            //Print total problems run
            totalNumber = additionNumber + subtractionNumber + multiplicationNumber + divisionNumber;
            
            System.out.println();
            System.out.println("Thanks for using the calculator!\n" + "Here are the amount of problems we solved;");
            System.out.println("Addition Problems: " + additionNumber);
            System.out.println("Subtraction Problems: " + subtractionNumber);
            System.out.println("Multiplication Problems: " + multiplicationNumber);
            System.out.println("Division Problems: " + divisionNumber);
            System.out.println("Total Problems: " + totalNumber);
            }
            
            
            //Main method
   public static void main (String args[]) {

      CS1Calculator newCalculator = new CS1Calculator();
      newCalculator.printIntro();
      if(newCalculator.askQuestion){
         newCalculator.calculate();
      }
      newCalculator.printReport();   
   }
}
