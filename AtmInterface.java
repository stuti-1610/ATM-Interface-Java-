import java.util.Scanner;

public class AtmInterface {
    public static Atm atm = new Atm();
    public static BankData bd = new BankData();
    public static void main(String[] args) {
        int choice;
        bd.readCustomers();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("  Welcome to ABC Bank  ");
            System.out.println("-----------------------");
            System.out.println("\n1.Create Acount.\t2.Insert ATM Card.\n3.Exit."); 
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    atm.signUp();
                    break;
                case 2:
                    atm.login();
                    break;
                case 3:
                    System.out.println("Thank you for using our ATM.\nGood Bye!!!");
                    break;
                default:
                    System.out.println("Enter a valid option please.");
                    break;
            }
        }while(choice != 3);
        sc.close();
    }
}
