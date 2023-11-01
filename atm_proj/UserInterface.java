package atm_proj;
import java.util.Scanner;

/*
* ATM Project using JAVA
* 
* Team - T16 - MnC IDD - 2021-26
* Team Members:
* 
* 21124013 - Mr. Ayush Raj
* 21124015 - Mr. B Niranjan
* 21124039 - Mr. Patil Mohit Rajaram
*/

// A helper class to handle console opearations for
// Login, Withdraw, View Details, Deposit, PIN change, Logout
public class UserInterface{
    private static Scanner input = new Scanner(System.in);

    public static Integer logIn() {
        System.out.print("Enter your AccountNo: ");
        Integer tempAccNo = input.nextInt(); input.nextLine();

        if (Database.accountMap.containsKey(tempAccNo)) {
            System.out.print("Enter your PIN: ");
            AccHolder tempAcc = Database.accountMap.get(tempAccNo);
            int tempPIN = input.nextInt(); input.nextLine();

            if (tempAcc.accountPIN == tempPIN) {
                System.out.println("You Have Logged In!\n");
                return tempAccNo;
            } else {
                System.out.println("Wrong PIN !\n");
                return 0;
            }     
        } else {
            System.out.println("Account Does not Exist !\n");
            return 0;
        }
    }

    public static void showSubMenu(Integer accNumber) {
        String prompt = "1. Withdraw\n2. View Details\n3. PIN Change\n4. Deposit\n5. Logout\n";

        while (true) {
            System.out.println(prompt + "Enter Choice: ");

            int choice = input.nextInt(); input.nextLine();
            switch(choice) {
                case 1: {
                    System.out.println("Enter Amount to Withdraw: ");
                    int amount = input.nextInt(); input.nextLine();
                    AccHolder tempAccount = Database.accountMap.get(accNumber);

                    if (amount >= tempAccount.balanceInRupees) {
                        System.out.println("Insufficient Balance !\n");
                    } else {
                        tempAccount.balanceInRupees -= amount;
                        Database.accountMap.remove(accNumber);
                        Database.accountMap.put(accNumber, tempAccount);
                        System.out.println("Amount Withdrawn !\n");
                    }
                    break;
                }

                case 2: {
                    Database.accountMap.get(accNumber).prettyPrintAccount();
                    break;
                }

                case 3: {
                    System.out.println("Enter new PIN (Only Last 4 digits will be taken): ");
                    int newPIN = input.nextInt() % 10000; input.nextLine();

                    if (newPIN / 1000 == 0) {
                        System.out.println("Invalid PIN !\n");
                    } else {
                        AccHolder tempAccount = Database.accountMap.get(accNumber);
                        tempAccount.accountPIN = newPIN;
                        Database.accountMap.remove(accNumber);
                        Database.accountMap.put(accNumber, tempAccount);
                        System.out.println("PIN changed !\n");
                    }
                    
                    break;
                }

                case 4: {
                    System.out.println("Enter Amount to Deposit: ");
                    int amount = input.nextInt(); input.nextLine();
                    AccHolder tempAccount = Database.accountMap.get(accNumber);

                    tempAccount.balanceInRupees += amount;
                    Database.accountMap.remove(accNumber);
                    Database.accountMap.put(accNumber, tempAccount);
                    System.out.println("Amount Deposited !\n");
                    break;
                    }

                default: {
                    System.out.println("Logging out...!");
                    return;
                }
            }
        }
    }
}
