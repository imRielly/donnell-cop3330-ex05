package oop.example;

import java.util.Scanner;

/*
Exercise 5 - Simple Math
You’ll often write programs that deal with numbers. And depending on the programming language you use,
you’ll have to convert the inputs you get to numerical data types.

Write a program that prompts for two numbers. Print the sum, difference, product, and quotient of those
numbers as shown in the example output:

Example Output
What is the first number? 10
What is the second number? 5
10 + 5 = 15
10 - 5 = 5
10 * 5 = 50
10 / 5 = 2

Constraints
Values coming from users will be strings. Ensure that you convert these values to numbers before doing the math.
Keep the inputs and outputs separate from the numerical conversions and other processing.
Generate a single output statement with line breaks in the appropriate spots.

Challenges
Revise the program to ensure that inputs are entered as numeric values.
Don’t allow the user to proceed if the value entered is not numeric.
Don’t allow the user to enter a negative number.
Break the program into functions that do the computations.
Implement this program as a GUI program that automatically updates the values when any value changes.
 */
public class App 
{
    public static void main( String[] args ){
        String nOne = requestNumber("What is the first number? ");
        String nTwo = requestNumber("What is the second number? ");
        String add = calculate(nOne, nTwo, "+");
        String subtract = calculate(nOne, nTwo, "-");
        String multiply = calculate(nOne, nTwo, "*");
        String divide = calculate(nOne, nTwo, "/");
        String out = String.format("%s\n%s\n%s\n%s", add, subtract, multiply, divide);
        System.out.println(out);
    }

    private static String requestNumber(String prompt){
        Scanner in = new Scanner(System.in);

        String input;

        try {
            System.out.print(prompt);
            input = in.nextLine();
            int testInput = Integer.parseInt(input);
        } catch (Exception e) {
            input = requestNumber(prompt);
        }

        return input;
    }

    private static String calculate(String one, String two, String operator) {
        String result = switch (operator) {
            case "+" -> String.valueOf(Math.addExact(Integer.parseInt(one), Integer.parseInt(two)));
            case "-" -> String.valueOf(Math.subtractExact(Integer.parseInt(one), Integer.parseInt(two)));
            case "*" -> String.valueOf(Math.multiplyExact(Integer.parseInt(one), Integer.parseInt(two)));
            case "/" -> String.valueOf(Math.floorDiv(Integer.parseInt(one), Integer.parseInt(two)));
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };

        return String.format("%s %s %s = %s", one, operator, two, result);
    }

}
