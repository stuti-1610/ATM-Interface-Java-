import java.io.*;
import java.util.LinkedList;

public class BankData {
    private String FILE_PATH = "Customer_Data\\customer_details.txt";
    AccountHolder ah = new AccountHolder();
    public void writeAccount(String f_name, String l_name, int age, int userid, int pin, String mobile_no) {

        // Write customer details to a text file
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write("First Name: " + f_name + "\n");
            writer.write("Last Name: " + l_name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("User ID: " + userid + "\n");
            writer.write("PIN: " + pin + "\n");
            writer.write("Phone Number: " + mobile_no + "\n");
            writer.write("Balance: " + 0 + "\n");
            writer.write("---------------------------\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void readCustomers(){

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            String f_name = null;
            String l_name = null;
            int age = 0;
            int userid = 0;
            int pin = 0;
            int balance = 0;
            String phoneNumber = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("First Name: ")) {
                    f_name = line.substring(12);
                } else if (line.startsWith("Last Name: ")) {
                    l_name = line.substring(11);
                } else if (line.startsWith("Age: ")) {
                    age = Integer.parseInt(line.substring(5));
                } else if (line.startsWith("User ID: ")) {
                    userid = Integer.parseInt(line.substring(9));
                } else if (line.startsWith("PIN: ")) {
                    pin = Integer.parseInt(line.substring(5));
                } else if (line.startsWith("Phone Number: ")) {
                    phoneNumber = line.substring(15);
                }else if (line.startsWith("Balance: ")) {
                    balance = Integer.parseInt(line.substring(9));
                } else if (line.equals("---------------------------")) {
                    // Create a new customer object and add it to the list
                    ah.addAccount(f_name, l_name, age, userid, pin, phoneNumber, balance);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public void updateCustomer(){
        LinkedList<Bank> customerList = AccountHolder.ACCOUNT_HOLDERS;
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
                for (Bank customer : customerList) {
                    writer.write("First Name: " + customer.getFirstName() + "\n");
                    writer.write("Last Name: " + customer.getLastName() + "\n");
                    writer.write("Age: " + customer.getAge() + "\n");
                    writer.write("User ID: " + customer.getUserId() + "\n");
                    writer.write("PIN: " + customer.getPin() + "\n");
                    writer.write("Phone Number: " + customer.getPhoneNumber() + "\n");
                    writer.write("Balance: " + customer.getBalance() + "\n");
                    writer.write("---------------------------\n");
                }
                System.out.println("Customer details updated and saved to file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
    }
}
