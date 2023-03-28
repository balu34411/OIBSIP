import java.util.Scanner;

class BankAccount {
    int balance;
    int PrevTransaction;
    String Customer_Name;
    String CustomerId;
    int flag = 0;

    BankAccount(String C_Name, String cId) {
        Customer_Name = C_Name;
        CustomerId = cId;
    }

    public final void clrscr() {
        try {
            try {
                final String os = System.getProperty("os.name");

                if (os.contains("Windows")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (final Exception e) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (final Exception es) {

        }

    }

    void checkId() {
        clrscr();
        System.out.println("Welcome " + Customer_Name);
        System.out.println();
        System.out.print("Please Enter The Customer ID or PIN To Continue\n");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(CustomerId)) {
            clrscr();
            showMenu();
        } else {

            System.out.println("Wrong credential's!!");


            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            PrevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            PrevTransaction = -amount;
        } else {
            clrscr();

            System.out.println("insufficient balance for the transaction !");

        }
    }

    void getPrevTransaction() {
        if (PrevTransaction > 0) {
            System.out.println("Deposited: " + PrevTransaction);
        } else if (PrevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(PrevTransaction));
        } else {
            System.out.println("No Transaction occurred ");
        }
    }

    public void transfer(double amount, BankAccount acc) {
        if (this.balance < amount) {
            clrscr();

            System.out.println("Transaction Failed due to insufficient balance ");

        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Account of " + this.Customer_Name + " becomes is of ₹ " + this.balance);
            System.out.println("Account of " + acc.Customer_Name + " becomes is of ₹ " + acc.balance);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + Customer_Name);
        System.out.println("Your ID is  " + CustomerId);
        do {
            System.out.println("\n");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");


            System.out.println("Enter the option to continue further");

            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch (option) {
                case '1':
                    clrscr();

                    System.out.println("Balance " + balance);

                    break;

                case '2':
                    clrscr();

                    System.out.println("Enter the amount to deposit");

                    int amount = sc.nextInt();
                    deposit(amount);

                    break;

                case '3':
                    clrscr();

                    System.out.println("Enter the amount to withdraw");

                    int amount2 = sc.nextInt();
                    withdraw(amount2);

                    break;

                case '4':
                    clrscr();

                    getPrevTransaction();

                    break;

                case '5':
                    clrscr();
                    System.out.println("++++++++++");
                    System.out.println("To whom");
                    BankAccount bb = new BankAccount("nitish kannarapu", "2091");
                    System.out.println(bb.Customer_Name);
                    System.out.println("++++++++++");
                    System.out.println("Amount to Transfer");
                    double am = sc.nextDouble();
                    transfer(am, bb);
                    break;

                case '6':
                    clrscr();
                    System.out.println("***");
                    break;

                default:
                    clrscr();
                    System.out.println("Invalid Option. Please Enter Again");
            }

        } while (option != 'F');
        System.out.println("ThankYou For using our service ");

    }
}



public class ATMInterface {

    public static void main(String[] args)
    {

        BankAccount ba = new BankAccount("babu", "2073");
        ba.checkId();
    }

}
