package atm_proj;
import java.util.ArrayList;
import java.io.Serializable;

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

class AccHolder implements Serializable {
    private static final long serialVersionUID = 998765l;
    public int accountNo;
    public String custName;
    public int balanceInRupees;
    // Using integer to avoid 
    // Floating point inaccuracy issues
    public int accountPIN;

    public AccHolder(int accNo, String name, int balance, int pin) {
        this.accountNo = accNo;         this.custName = name;
        this.balanceInRupees = balance; this.accountPIN = pin;
    }

    public void prettyPrintAccount() {
        System.out.println("Customer Name :\t" + this.custName);
        System.out.println("Account  No.  :\t" + this.accountNo);
        System.out.println("Balance  INR  :\t" + this.balanceInRupees + "\n\n");
    }
}
