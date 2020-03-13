import java.util.Scanner;

public class Initials {
   public static void main (String[] args) {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Enter first name: ");  // Prompts the user for their first name
      String firstName = keyboard.nextLine();
      
      System.out.println("Enter middle name: "); // Prompts the user for their middle name
      String middleName = keyboard.nextLine();
      
      System.out.println("Enter last name: "); // Prompts the user for their last name
      String lastName = keyboard.nextLine();
      
      //Finds the first characters in each name
      char firstInitial = firstName.charAt(0);
      char middleInitial = middleName.charAt(0);
      char lastInitial = lastName.charAt(0);
      
      System.out.println("Your initials are " + firstInitial + ". " + middleInitial + ". " + lastInitial + "."); // Outputs initials
   }
}
