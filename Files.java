/**
    This program reads a file that contains multiple data points that need to be extracted. Data is labor statistics from the United States healthcare industry.
    It seperates each row of the file into four parts.
    1: The half of the year, 1 or 2.
    2: The name of the state.
    3: What area of government is represented.
    4: The wages for that area of government.
    Once it seperates those lines out, it totals up the wages for each half of the year based on the area of government. Then it extracts the totals at the bottom of
    the document. It compares the two, and notates if there are any differences. It then gets the average that each area of government spent. All of this data is output
    into a data file.
*/

import java.util.Scanner;
import java.io.*;	

public class Files
{

    public static void main (String args[]) throws IOException
    {
        // Open the file and create a new scanner.
        File inputFileName = new File("C:\\Users\\kevin\\Documents\\Metro State\\CS 1050\\Project 4 - Files\\Project 04 - Input.txt"); 
        Scanner inputFile = new Scanner(inputFileName);

        double totalFedDollarsQ1 = 0;
        double totalFedDollarsQ2 = 0;
        double totalStateDollarsQ1 = 0;
        double totalStateDollarsQ2 = 0;

        double fedGovQ1 = 0;
        double fedGovQ2 = 0;
        double stateGovQ1 = 0;
        double stateGovQ2 = 0;

        double fedQ1Diff = 0;
        double fedQ2Diff = 0;
        double stateQ1Diff = 0;
        double stateQ2Diff = 0;

        int fedCountQ1 = 0;
        int fedCountQ2 = 0;
        int stateCountQ1 = 0;
        int stateCountQ2 = 0;

        double fedAverageQ1 = 0;
        double fedAverageQ2 = 0;
        double stateAverageQ1 = 0;
        double stateAverageQ2 = 0;
   
        // Extracting and adding together various totals for Federal and State government, 
        // based on which half of the year it is.
        while (inputFile.hasNextLine())
        {
            String data = inputFile.nextLine();

            int index1 = data.indexOf(",");
            int index2 = data.indexOf(",", index1 + 1);
            int index3 = data.indexOf(",", index2 + 1);
            
            String half = data.substring(0, index1);
            String state = data.substring(index1 + 1, index2);
            String govType = data.substring(index2 + 1, index3);
            String dollarString = data.substring(index3 + 1, data.length());

            if(state.contains("Statewide"))
            {
                if(govType.contains("Federal Government"))
                {
                    double dollars = Double.valueOf(dollarString);

                    if(half.contains("1"))
                    {
                        fedGovQ1 = fedGovQ1 + dollars;
                        fedCountQ1++;
                    }
                    else if(half.contains("2"))
                    {
                        fedGovQ2 = fedGovQ2 + dollars;
                        fedCountQ2++;
                    }
                }
                else if(govType.contains("State Government"))
                {
                    double dollars = Double.valueOf(dollarString);

                    if(half.contains("1"))
                    {
                        stateGovQ1 = stateGovQ1 + dollars;
                        stateCountQ1++;
                    }
                    else if(half.contains("2"))
                    {
                        stateGovQ2 = stateGovQ2 + dollars;
                        stateCountQ2++;
                    }
                }
            }
            else if(state.contains("U.S. TOTAL"))
            {
                break;
            }
        }

        // Creating a new scanner to extract our U.S. Totals.
        Scanner inputFileTotals = new Scanner(inputFileName);

        // Extracting the U.S. Totals for State and Federal Government,
        // based on which half of the year it is.
        while(inputFileTotals.hasNextLine())
        {
            String data = inputFileTotals.nextLine();

            int index1 = data.indexOf(",");
            int index2 = data.indexOf(",", index1 + 1);
            int index3 = data.indexOf(",", index2 + 1);
            
            String totalHalf = data.substring(0, index1);
            String total = data.substring(index1 + 1, index2);
            String totalGovType = data.substring(index2 + 1, index3);
            String totalDollarString = data.substring(index3 + 1, data.length());

            if(total.contains("U.S. TOTAL"))
            {
                if(totalGovType.contains("Federal Government"))
                {
                    double totalDollars = Double.valueOf(totalDollarString);

                    if(totalHalf.contains("1"))
                    {
                        totalFedDollarsQ1 = totalDollars;
                    }
                    else if(totalHalf.contains("2"))
                    {
                        totalFedDollarsQ2 = totalDollars;
                    }
                }
                else if(totalGovType.contains("State Government"))
                {
                    double totalDollars = Double.valueOf(totalDollarString);

                    if(totalHalf.contains("1"))
                    {
                        totalStateDollarsQ1 = totalDollars;
                    }
                    else if(totalHalf.contains("2"))
                    {
                        totalStateDollarsQ2 = totalDollars;
                    }
                }
            }
        }

        // Finding the differences of our calculated totals and the U.S. Totals.
        fedQ1Diff = fedGovQ1 - totalFedDollarsQ1;
        fedQ2Diff = fedGovQ2 - totalFedDollarsQ2;
        stateQ1Diff = stateGovQ1 - totalStateDollarsQ1;
        stateQ2Diff = stateGovQ2 - totalStateDollarsQ2;

        // Finding the average of federal and state calculated totals.
        fedAverageQ1 = fedGovQ1 / fedCountQ1;
        fedAverageQ2 = fedGovQ2 / fedCountQ2;
        stateAverageQ1 = stateGovQ1 / stateCountQ1;
        stateAverageQ2 = stateGovQ2 / stateCountQ2;

        // Creating, or overriding, our output file so we can output the data.
        FileWriter outputFileName = new FileWriter("C:\\Users\\kevin\\Documents\\Metro State\\CS 1050\\Project 4 - Files\\Project 04 - Output.txt");
        PrintWriter outputFile = new PrintWriter(outputFileName);

        // Outputting our various data points.
        outputFile.println("Statewide Federal Q1 Total: $" + String.format("%.0f", fedGovQ1) + "    " + 
                           "Statewide Federal Q2 Total: $" + String.format("%.0f", fedGovQ2) + "    " + 
                           "Statewide State Q1 Total $" + String.format("%.0f", stateGovQ1) + "    " + 
                           "Statewide State Q2 Total $" + String.format("%.0f", stateGovQ2));

        outputFile.println("Federal Q1 U.S. Total: $" + String.format("%.0f", totalFedDollarsQ1) + "    " + 
                           "Federal Q2 U.S. Total: $" + String.format("%.0f", totalFedDollarsQ2) + "    " + 
                           "State Q1 U.S. Total: $" + String.format("%.0f", totalStateDollarsQ1) + "    " + 
                           "State Q2 U.S. Total: $" + String.format("%.0f", totalStateDollarsQ2));

        outputFile.println("Federal Q1 Difference: $" + String.format("%.0f", fedQ1Diff) + "    " + 
                           "Federal Q2 Difference: $" + String.format("%.0f", fedQ2Diff) + "    " + 
                           "State Q1 Difference: $" + String.format("%.0f", stateQ1Diff) + "    " + 
                           "State Q2 Difference: $" + String.format("%.0f", stateQ2Diff));

        // Since our calculated total and the U.S. total is different, output !!!!
        outputFile.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + 
                           "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        outputFile.println();
        outputFile.println();

        outputFile.println("Averages:");
        outputFile.println("Statewide Federal Q1 Average: $" + String.format("%.0f", fedAverageQ1) + "    " + 
                           "Statewide Federal Q2 Average: $" + String.format("%.0f", fedAverageQ2) + "    " + 
                           "Statewide State Q1 Average: $" + String.format("%.0f", stateAverageQ1) + "    " + 
                           "Statewide State Q2 Average: $" + String.format("%.0f", stateAverageQ2));


        // Closing the various files.
        inputFile.close();
        inputFileTotals.close();
        outputFile.close();
    }
}
