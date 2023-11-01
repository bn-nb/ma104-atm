package atm_proj;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

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

class Database {
    // A class of static methods for
    // reading and writing data in .ser files
    // We can use add method in Arraylist, inside a block only

    public static ArrayList<AccHolder> 
        custList = new ArrayList<AccHolder>(20);

    public static HashMap<Integer, AccHolder> 
        accountMap = new HashMap<Integer, AccHolder>(20);

    public static void initializeData() {
        // custList.add(new AccHolder(10001, "Ashton", 15000, 2222));
        // custList.add(new AccHolder(10002, "Barney", 15000, 5555));
        // custList.add(new AccHolder(20001, "Chloey", 20000, 4444));
        // custList.add(new AccHolder(20002, "Daniel", 20000, 1111));
        // custList.add(new AccHolder(20003, "Elaine", 30000, 3333));
        
        for (AccHolder tempCust : Database.custList) {
            accountMap.put(tempCust.accountNo, tempCust);
        }
    }    

    // Try-with-resources closes streams automatically
    // We just need to catch the errors for compilation

    public static void writeData(String directory) {
        try(
                FileOutputStream tempDB
                = new FileOutputStream(directory, false);
                // true to append, false to overwrite
                ObjectOutputStream tempOUT
                = new ObjectOutputStream(tempDB);
            ) {            
            
            for (AccHolder tempAccount: Database.custList) {
                tempOUT.writeObject(tempAccount);
            }
        }
        catch (IOException ioex) {}
    }

    public static void readData(String directory) {
        try(
                FileInputStream tempDB
                = new FileInputStream(directory);
                ObjectInputStream tempIN
                = new ObjectInputStream(tempDB);
            ) {
            while(true) {
                @SuppressWarnings("unchecked")
                AccHolder tempAccount = (AccHolder) tempIN.readObject();
                Database.custList.add(tempAccount);
            }            
        }
        catch (IOException ioex) {}
        catch (ClassNotFoundException clsnf) {}
    }
}
