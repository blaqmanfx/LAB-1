import java.util.Scanner;
 
 
/*
    Week 2 Lab: Weather Report Program
    Topics: Conditional statements, loops, typecasting, input validation
    Objective: Ask the user for weather info, validate input, and display a full report
*/
 
 
public class Main {
    public static void main(String[] args) {
 
 
        Scanner input = new Scanner(System.in);
 
 
        /*
        STEP 1: Declare variables for weather information
        a) Today's weather conditions (String)
        b) Possibility of precipitation (String)
        c) Wind speed (String)
        d) Daily high temperature (int or double)
        e) Daily low temperature (int or double)
        f) UV index (int)
        */
 
 
        // TODO: Declare your variables here
        String weatherConditions;
        String precipitation;
        String windSpeed;
        double highTemp;
        double lowTemp;
        int uvIndex;
 
 
        /*
        STEP 2: Get input from the user using Scanner
        - Ask for each variable above
        - Validate numeric input using loops
        - Example: Ensure highTemp >= lowTemp
        */
 
 
        // TODO: Prompt user and read input

        System.out.print("Enter today's weather conditions (e.g., Snowy, Sunny, Rainy): ");
        weatherConditions = input.nextLine();

        System.out.print("Enter possibility of precipitation (e.g., 20%): ");
        precipitation = input.nextLine();

        System.out.print("Enter wind speed (e.g., 15 km/h, Light, Strong): ");
        windSpeed = input.nextLine();

        System.out.print("Enter daily high temperature (°C): ");
        highTemp = input.nextDouble();

        System.out.print("Enter daily low temperature (°C): ");
        lowTemp = input.nextDouble();

    
        // TODO: Use loops to validate high/low temperatures and UV index

        while (highTemp < lowTemp) {
            System.out.println("Error: High temperature must be greater than or equal to low temperature.");
            System.out.print("Please re-enter daily high temperature (°C): ");
            highTemp = input.nextDouble();
            System.out.print("Please re-enter daily low temperature (°C): ");
            lowTemp = input.nextDouble();
        }

        System.out.print("Enter UV index (0-11+): ");
        uvIndex = input.nextInt();

        // Validate UV index is between 0 and 11+
        while (uvIndex < 0 || uvIndex > 11) {
            System.out.println("Error: UV index must be between 0 and 11+.");
            System.out.print("Please re-enter UV index (0-11+): ");
            uvIndex = input.nextInt();
        }


 
 
        /*
        STEP 3: Typecasting (if needed)
        - Example: if you read a double but want to display as int
        */
 
 
        // TODO: Apply typecasting where necessary

        int highTempInt = (int) highTemp;
        int lowTempInt = (int) lowTemp;

        // Calculate average temperature
        double avgTemp = (highTemp + lowTemp) / 2.0;
 
 
        /*
        STEP 4: Conditional statements
        - Example: 
          - If UV index >= 6, suggest "Use sunscreen"
          - If precipitation >= 50%, suggest "Carry an umbrella"
          - If wind speed > 40 km/h, suggest "Windy conditions"
        */
 
 
        // TODO: Write if, if-else, or nested if statements to display tips
        String uvTips = "";
        String precipTips = "";
        String windTips = "";
        String tempTips = "";

        System.out.println("      WEATHER ANALYSIS");

        // UV Index tips
        if (uvIndex >= 8) {
            uvTips = "UV Index is very high! Use sunscreen and wear protective clothing.";
        } else if (uvIndex >= 6) {
            uvTips = "UV Index is high. Use sunscreen when outdoors.";
        } else if (uvIndex >= 3) {
            uvTips = "UV Index is moderate. Some protection recommended.";
        } else {
            uvTips = "UV Index is low. Minimal sun protection needed.";
        }

        // Precipitation tips
        if (precipitation.contains("%")) {
            String precipValueStr = precipitation.replace("%", "").trim();
            try {
                int precipPercent = Integer.parseInt(precipValueStr);
                if (precipPercent >= 70) {
                    precipTips = "High chance of rain! Definitely carry an umbrella.";
                } else if (precipPercent >= 50) {
                    precipTips = "Moderate chance of rain. Bring an umbrella to be safe.";
                } else if (precipPercent >= 30) {
                    precipTips = "Low chance of rain. Umbrella optional.";
                } else {
                    precipTips = "Very low chance of rain. No umbrella needed.";
                }
            } catch (NumberFormatException e) {
                precipTips = "Precipitation: " + precipitation;
            }
        } else {
            precipTips = "Precipitation forecast: " + precipitation;
        }

        // Wind speed tips
         if (windSpeed.contains("km/h")) {
            String speedStr = windSpeed.replace("km/h", "").trim();
            try {
                int speed = Integer.parseInt(speedStr);
                if (speed > 40) {
                    windTips = "Very windy conditions! Secure loose objects.";
                } else if (speed > 25) {
                    windTips = "Windy conditions. Hold onto your hat!";
                } else if (speed > 10) {
                    windTips = "Light breeze. Pleasant conditions.";
                } else {
                    windTips = "Calm winds. Perfect weather.";
                }
            } catch (NumberFormatException e) {
                windTips = "Wind: " + windSpeed;
            }
        } else {
            windTips = "Wind: " + windSpeed;
        }

        // Temperature tips
        if (avgTemp >= 30) {
            tempTips = "It's quite hot today. Stay hydrated!";
        } else if (avgTemp >= 20) {
            tempTips = "Warm weather. Enjoy your day!";
        } else if (avgTemp >= 10) {
            tempTips = "Cool weather. A light jacket is recommended.";
        } else if (avgTemp >= 0) {
            tempTips = "Cold weather. Dress warmly!";
        } else {
            tempTips = "Freezing temperatures! Bundle up!";
        }


 
 
        /*
        STEP 5: Create a fullReport String
        - Combine all user inputs and tips into one formatted sentence or paragraph
        - Use String concatenation (+) or String.format()
        */
 
 
        // TODO: Construct your full weather report here
         
        String fullReport = "Today's Weather Report:\n" +
                            "Conditions: " + weatherConditions + "\n" +
                            "Precipitation: " + precipitation + "\n" +
                            "Wind Speed: " + windSpeed + "\n" +
                            "High Temperature: " + highTempInt + "°C\n" +
                            "Low Temperature: " + lowTempInt + "°C\n" +
                            "UV Index: " + uvIndex + "\n\n" +
                            "Weather Tips:\n" + uvTips + "\n" + precipTips + "\n" +
                                windTips + "\n" + tempTips + "\n";
 
        /*
        STEP 6: Print the full weather report
        */
 
 
        // TODO: Output your report using System.out.println()

        System.out.println(fullReport);
 
 
        /*
        STEP 7: Optional extra challenge
        - Use loops to ask if the user wants to enter another day's report
        - Continue until the user types "no"
        */
 
 
        // TODO: Implement loop for multiple reports
        
       String continueReport;

       do {
            System.out.print("\nWould you like to enter another day's report? (yes/no): ");
            continueReport = input.nextLine().trim().toLowerCase();
    
        if (continueReport.equals("yes")) {
        
            System.out.println("  RESTARTING WEATHER REPORT...");
        
            main(args); // Restart the program
            return; // Exit current instance after restart
        }else if (continueReport.equals("no")) {
            System.out.println("\nThank you for using the Weather Report Program!");
            break; // Exit the loop
        } else {
            System.out.println("Invalid input! Please enter 'yes' or 'no'.");
        // Loop continues for invalid input
    }
    
} while (true); // Keep looping until valid 'yes' or 'no'

    input.close();

    }
}
 