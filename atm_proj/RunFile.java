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

public class RunFile{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Database.readData("atm_proj/Accounts.ser");
        Database.initializeData();

        System.out.println("Welcome to Global ATM !");
        char continuePrompt = 'Y';

        while (continuePrompt == 'Y') {
            Integer tempAccountNum = UserInterface.logIn();
            if (tempAccountNum == 0) {
                System.out.println("Log-in attempt unsuccessful!");
                System.out.println("Do you wish to continue ? (Y/N)");
                continuePrompt = input.next().strip().toUpperCase().charAt(0); input.nextLine();
                continue;
            } else {
                UserInterface.showSubMenu(tempAccountNum);
            }
            System.out.println("Do you wish to continue ? (Y/N)");
            continuePrompt = input.next().strip().toUpperCase().charAt(0); input.nextLine();            
        }

        System.out.println("Exiting...!");


        Database.writeData("atm_proj/Accounts.ser");
                
    }
}
