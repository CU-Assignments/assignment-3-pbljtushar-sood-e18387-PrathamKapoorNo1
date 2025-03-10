import java.util.Scanner;

public class E3A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a Number :- ");
            double number = scanner.nextDouble();

            if (number < 0) {
                throw new IllegalArgumentException("Error :- Cannot Calculate the Square Root of a Negative Number.");
            }

            double result = Math.sqrt(number);
            System.out.println("Square Root :- " + result);

        } catch (Exception e) {
            System.out.println("Error :- Invalid Input. Please Enter a Valid Number.");
        } finally {
            scanner.close();
        }
    }
}
