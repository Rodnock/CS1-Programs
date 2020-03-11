// ---
// Description: This program tracks grocery items, prices, and if the item is on sale. Then it outputs a receipt.
// ---

import java.util.Scanner;

public class Groceries {

   public static void main (String args[]) {
   
   Scanner keyboard = new Scanner(System.in);
   String answer;
   boolean getItem;
   String item;
   double price;
   String sale;
   double salePrice = 0;
   double totalPrice = 0;
   double actualPrice = 0;
   double finalPrice = 0;
   double tax = .07;
   double totalTax = 0;
   String receipt = new String ("Purchases: \n");
   
   System.out.print("Input grocery items? (y/n): ");
   answer = keyboard.nextLine();
   
   if(answer.equalsIgnoreCase("y")){
      getItem = true;
   }
   else{
      getItem = false;
   }
   
      while(getItem){
         
         System.out.println();
         System.out.print("Input item name: ");
         item = keyboard.nextLine();
         
         System.out.print("Input item price: $");
         price = keyboard.nextDouble();
         keyboard.nextLine();
         
         System.out.print("Is the item on sale? (y/n): ");
         sale = keyboard.nextLine();
            if(sale.equalsIgnoreCase("y")){
               salePrice = price * .20;
               actualPrice = price - salePrice;
               totalPrice = totalPrice + actualPrice;
               
               receipt = receipt + item + ": $" + String.format("%.02f", price) + 
               "   SALE: $" + String.format("%.02f", actualPrice) + "\n";
            }
            else{
               totalPrice = totalPrice + price;
               
               receipt = receipt + item + ": $" + String.format("%.02f", price) + "\n";
            }
         
         System.out.println();         
         System.out.print("Input more items? (y/n): ");
         answer = keyboard.nextLine();
         

         
            if(answer.equalsIgnoreCase("y")){
               getItem = true;
            }
            else{
               getItem = false;
            }
      }
      
      totalTax = totalPrice * tax;
      finalPrice = totalTax + totalPrice; 
      
      
      System.out.println();
      System.out.println("Grocery Bill");
      System.out.println();
      System.out.println(receipt);
      System.out.println("Total price of items purchased: $" + 
                         String.format("%.02f", totalPrice));
      System.out.println("Tax (7%): $" + String.format("%.02f", totalTax));   
      System.out.println("Total price with tax: $" + String.format("%.02f", finalPrice));
   }
   
}
