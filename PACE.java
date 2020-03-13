import java.util.Scanner;

public class PACE {
   public static void main (String[] args) {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Enter food: ");  // Prompts the user for the food
      String foodName = keyboard.nextLine();
      
      System.out.println("Enter calories: "); // Prompts the user for the calories of the food
      int calories = keyboard.nextInt();
      
      double walkingTime = (int)(calories / 5.4); // Calculates walking time
      System.out.println("Minutes to walk to burn calories: " + walkingTime); // Outputs walking time
   }
}
