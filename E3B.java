import java.util.Scanner;

class ATM {
    private int pin;
    private double balance;

    public ATM(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public void authenticate(int enteredPin) throws Exception {
        if (enteredPin != pin) {
            throw new Exception("Error :- Invalid PIN.");
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Error :- Insufficient Balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal Successful! Current Balance :- " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class E3B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Set your PIN :- ");
        int userPin = scanner.nextInt();

        System.out.print("Enter the Initial Balance :- ");
        double userBalance = scanner.nextDouble();

        ATM atm = new ATM(userPin, userBalance);

        try {
            System.out.print("Enter the PIN :- ");
            int enteredPin = scanner.nextInt();
            atm.authenticate(enteredPin);

            System.out.print("Withdraw Amount :- ");
            double amount = scanner.nextDouble();
            atm.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Current Balance :- " + atm.getBalance());
            scanner.close();
        }
    }
}