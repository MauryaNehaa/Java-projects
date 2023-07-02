import java.text.DecimalFormat;
import java.util.Scanner;

public class TravelPlanner{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println("Welcome to the Travel Planner!");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello," +name+"!");

        System.out.println("Where would you like to travel?");
        String destination = scanner.nextLine();

        System.out.println("How many members are travelling?");
        String member = scanner.nextLine();

        System.out.println("How many days are you planning to spend  in " + destination +"?");
        int days = scanner.nextInt();

        System.out.println("what is your budget for the trip(in USD)?");
        double budget = scanner.nextDouble();

        System.out.println("what is the currency symbol of your destination?");
        scanner.nextLine();
        String currencySymbol = scanner.nextLine();

        System.out.println("what is the conversion rate from 1 USD to " + currencySymbol);
        double conversionRate = scanner.nextDouble();

        // Calculate the converted budget
        double convertedBudget = budget * conversionRate;

        System.out.println("\n********* Travel Itinerary *********");
        System.out.println("Name: " + name);
        System.out.println("Destination: " + destination);
        System.out.println("Members: " + member);
        System.out.println("Duration: " + days + "days");
        System.out.println("Budget: " + budget + "USD");
        System.out.println("Currency: " + currencySymbol);
        System.out.println("Conversion Rate: 1 USD = " + conversionRate+ " "+ currencySymbol);
        System.out.println("Converted Budget: " + decimalFormat.format(convertedBudget) + " " + currencySymbol);
        System.out.println("****************************");
    }
}
