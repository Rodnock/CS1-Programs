// ---
// Description: This program requests grades for 5 quizzes, finds the average score, and the letter grade of that average score.
// ---

import java.util.Scanner;

public class Quizzes {

   public static void main (String args[]) {
   
   Scanner keyboard = new Scanner(System.in);
   String name;
   int x;
   double quizScore;
   double totalScore;
   double average;
   double percent;
   String report = new String ();
   
      System.out.println("This program will take the score of 5 quizzes, and then output the average score, and find the letter grade for it.");
      System.out.print("What is your name?: ");
      name = keyboard.nextLine();
      System.out.println();
      
      totalScore = 0;
      
      for(x = 1; x <=5; x++){
         
         System.out.print("Quiz #" + x + ": ");
         quizScore = keyboard.nextDouble();
         
         report = report + "Quiz #" + x + ": " + quizScore + "\n";
         totalScore = totalScore + quizScore;
         
      }
      
      average = totalScore / 5;
      percent = average / 25;
      percent = percent * 100;
   
      System.out.println();
      System.out.println("Quiz report for " + name);
      System.out.println();
   
      System.out.println(report);
   
      System.out.println("Quiz Average: " + average + " = " + percent + "%");
      
         if(percent >= 90){
            System.out.println("Quiz Grade: A");
            System.out.println("Great job!");
         }
            else if(percent >= 80 && percent <= 89.9){
               System.out.println("Quiz Grade: B");
               System.out.println("Well done!");
            }
            else if(percent >= 70 && percent <= 79.9){
               System.out.println("Quiz Grade: C");
               System.out.println("Try harder.");
            }
            else if(percent >= 60 && percent <= 69.9){
               System.out.println("Quiz Grade: D");
               System.out.println("Study more.");
            }
            else if(percent >= 0 && percent <= 59.9){
               System.out.println("Quiz Grade: F");
               System.out.println("Pay attention in class.");
            }
            
   }

}
