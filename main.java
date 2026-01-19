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
        String WeatherConditions;
        String Precipitation;
        String WindSpeed;
        double HighTemp;
        double LowTemp;
        int UVIndex;
 
 
        /*
        STEP 2: Get input from the user using Scanner
        - Ask for each variable above
        - Validate numeric input using loops
        - Example: Ensure highTemp >= lowTemp
        */
 
 
        // TODO: Prompt user and read input

        System.out.print("Enter today's weather conditions (e.g., Sunny, Rainy): ");
        WeatherConditions = input.nextLine();

        System.out.print("Enter possibility of precipitation (e.g., 20%): ");
        Precipitation = input.nextLine();

        System.out.print("Enter wind speed (e.g., 15 km/h, Light, Strong): ");
        WindSpeed = input.nextLine();

        System.out.print("Enter daily high temperature (°C): ");
        HighTemp = input.nextDouble();

        System.out.print("Enter daily low temperature (°C): ");
        LowTemp = input.nextDouble();

    
        // TODO: Use loops to validate high/low temperatures and UV index

        while (HighTemp < LowTemp) {
            System.out.println("Error: High temperature must be greater than or equal to low temperature.");
            System.out.print("Please re-enter daily high temperature (°C): ");
            HighTemp = input.nextDouble();
            System.out.print("Please re-enter daily low temperature (°C): ");
            LowTemp = input.nextDouble();
        }

        System.out.print("Enter UV index (0-11+): ");
        UVIndex = input.nextInt();

        // Validate UV index is between 0 and 11+
        while (UVIndex < 0 || UVIndex > 11) {
            System.out.println("Error: UV index must be between 0 and 11+.");
            System.out.print("Please re-enter UV index (0-11+): ");
            UVIndex = input.nextInt();
        }


 
 
        /*
        STEP 3: Typecasting (if needed)
        - Example: if you read a double but want to display as int
        */
 
 
        // TODO: Apply typecasting where necessary

        int HighTempInt = (int) HighTemp;
        int LowTempInt = (int) LowTemp;

        // Calculate average temperature
        double avgTemp = (HighTemp + LowTemp) / 2.0;
 
 
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
        if (UVIndex >= 8) {
            uvTips = "UV Index is very high! Use sunscreen and wear protective clothing.";
        } else if (UVIndex >= 6) {
            uvTips = "UV Index is high. Use sunscreen when outdoors.";
        } else if (UVIndex >= 3) {
            uvTips = "UV Index is moderate. Some protection recommended.";
        } else {
            uvTips = "UV Index is low. Minimal sun protection needed.";
        }

        // Precipitation tips
        if (Precipitation.contains("%")) {
            String precipValueStr = Precipitation.replace("%", "").trim();
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
                precipTips = "Precipitation: " + Precipitation;
            }
        } else {
            precipTips = "Precipitation forecast: " + Precipitation;
        }

        // Wind speed tips
         if (WindSpeed.contains("km/h")) {
            String speedStr = WindSpeed.replace("km/h", "").trim();
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
                windTips = "Wind: " + WindSpeed;
            }
        } else {
            windTips = "Wind: " + WindSpeed;
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
                            "Conditions: " + WeatherConditions + "\n" +
                            "Precipitation: " + Precipitation + "\n" +
                            "Wind Speed: " + WindSpeed + "\n" +
                            "High Temperature: " + HighTempInt + "°C\n" +
                            "Low Temperature: " + LowTempInt + "°C\n" +
                            "UV Index: " + UVIndex + "\n\n" +
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
        
        System.out.print("Would you like to enter another day's report? (yes/no): ");
        String continueReport = input.nextLine();
        if (continueReport.equalsIgnoreCase("yes")) {
            main(null); // Restart the program
        } else {
            System.out.println("Thank you for using the Weather Report Program!");
        }


 
 
        input.close();
    }
}
 