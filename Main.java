import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Setup scanner for reading input from the console.
        Scanner scanner = new Scanner(System.in);
        double numerator;
        double denominator;
        Rational firstR;
        Rational secondR;

        // Prompt user and read the first and second rational numbers.
        System.out.print("Please enter first numerator: ");
        numerator = scanner.nextDouble();
        System.out.print("Please enter first denominator: ");
        denominator = scanner.nextDouble();
        firstR = new Rational(numerator, denominator);
        System.out.print("Thank you, now enter second numerator: ");
        numerator = scanner.nextDouble();
        System.out.print("Please enter second denominator: ");
        denominator = scanner.nextDouble();
        secondR = new Rational(numerator, denominator);

        // Display the entered and the reduced rational numbers.
        System.out.println("You entered: " + firstR + "," + secondR);
        firstR = firstR.reduce();
        secondR = secondR.reduce();
        System.out.println("After reduced: " + firstR + "," + secondR);


        printGreaterThenAndEquals(firstR, secondR);
        printPlusMinusMultipleDivide(firstR,secondR);
    }


    // Method to display comparison results between two rational numbers.
    public static void printGreaterThenAndEquals(Rational firstR, Rational secondR) {
        if (firstR.equals(secondR)) {
            System.out.println(firstR + " = " + secondR);
            return;
        }
        if (firstR.greaterThan(secondR)) {
            System.out.println(firstR + " not equals " + secondR);
            System.out.println(firstR + " > " + secondR);
            return;
        }

        System.out.println(firstR + " not equals " + secondR);
        System.out.println(firstR + " < " + secondR);
    }

    // Method to perform and display results of arithmetic operations between two rational numbers.
    public static void printPlusMinusMultipleDivide(Rational firstR,Rational secondR){
        Rational result = firstR.plus(secondR);
        System.out.println(firstR+" + "+secondR+" = "+result);
        result = firstR.minus(secondR);
        System.out.println(firstR+" - "+secondR+" = "+result);
        result = firstR.multiply(secondR);
        System.out.println(firstR+" * "+secondR+" = "+result);
        result = firstR.divide(secondR);
        System.out.println(firstR+" / "+secondR+" = "+result);
    }

}