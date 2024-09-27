import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // INITIAL SETUP OF THE EXISTING ACCOUNT
        int balance = 1000; // INITIAL BALANCE
        int pin = 1234; // SAMPLE PIN
        boolean isAuthenticated = false;
        String transactionHistory = "";

        System.out.println("\n------------WELCOME TO THE ATM !!------------\n");

        // AUTHENTICATION
        System.out.print("ENTER YOUR PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == pin) {
            isAuthenticated = true;
            System.out.println("\n----AUTHENTICATION SUCCESSFUL!!----\n");
        } else {
            System.out.println("\n----INCORRECT PIN,INVALID USER. EXITING.----\n");
            return;
        }

        // ATM OPERATIONS LOOP
        while (isAuthenticated) {
            // DISPLAYING MENU
            System.out.println("PLEASE CHOOSE AVAILABLE OPTIONS:");
            System.out.println("1. CHECK BALANCE");
            System.out.println("2. DEPOSIT");
            System.out.println("3. WITHDRAW");
            System.out.println("4. VIEW TRANSATION HISTORY");
            System.out.println("5. EXIT");
            System.out.print("\nYOUR CHOICE: ");

            int choice = sc.nextInt();

            if (choice == 1) { // CHECK BALANCE
                System.out.println("YOUR CURRENT BALANCE IS : $ " + balance);
                transactionHistory = transactionHistory + "CHECKED BALANCE : $" + balance + "\n";
            } else if (choice == 2) { // DEPOSIT
                System.out.print("ENTER DEPOSIT AMOUNT : $");
                int depositAmount = sc.nextInt();
                balance = balance + depositAmount;
                System.out.println("SUCCESSFULLY DEPOSITED $" + depositAmount);
                transactionHistory = transactionHistory + "DEPOSITED: $" + depositAmount + "\n";
            } else if (choice == 3) { // WITHDRAW
                System.out.print("ENTER WITHDRAWL AMOUNT: $");
                int withdrawalAmount = sc.nextInt();
                if (withdrawalAmount <= balance) {
                    balance = balance - withdrawalAmount;
                    System.out.println("Successfully WITHDREW $" + withdrawalAmount);
                    transactionHistory = transactionHistory + "WITHDREW: $" + withdrawalAmount + "\n";
                } else {
                    System.out.println("INSUFFICIENT FUND.");
                    transactionHistory += "FAILED WITHDRAWAL: $" + withdrawalAmount + " (INSUFFICIENT FUND.)\n";
                }
            } else if (choice == 4) { // VIEW TRANSATION HISTORY
                System.out.println("TRANSATION HISTORY:");
                System.out.println(transactionHistory);
            } else if (choice == 5) { // EXITING
                System.out.println("\n----------THANK YOU FOR USING THE ATM !! HAVE A NICE DAY----------\n");
                break;
            } else {
                System.out.println("\nINVALID CHOICE. PLEASE TRY AGAIN. \n");
            }

            System.out.println();
        }
    }
}
