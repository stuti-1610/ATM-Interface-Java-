import java.util.LinkedList;

public class Bank {
    AccountHolder ah = new AccountHolder(); 
    String f_name, l_name;
    String mobile_no;
    LinkedList<String> transactions_list;
    private int userid, pin, age;
    private int balance;

    public Bank(){}

    public Bank(String f_name, String l_name, int age, int userid, int pin, String mobile_no, int balance){
        this.f_name = f_name;
        this.l_name = l_name;
        this.age = age;
        this.userid = userid;
        this.pin = pin;
        this.mobile_no = mobile_no;
        this.balance = balance;
        this.transactions_list = new LinkedList<>();
    }

    public String getName(){
        return this.f_name + " " + this.l_name;
    }

    public String getFirstName(){
        return this.f_name;
    }

    public String getLastName(){
        return this.l_name;
    }
    
    public int getAge(){
        return this.age;
    }

    public int getUserId(){
        return this.userid;
    }

    public int getPin(){
        return this.pin;
    }

    public int getBalance(){
        return this.balance;
    }

    public String getPhoneNumber(){
        return this.mobile_no;
    }

    public void addBalance(double amount){
        this.balance += amount;
        //generate transaction message     
        this.generateTransaction(userid, amount, "Deposit", userid, "Successfull");
    }

    public boolean reduceBalance(double amount){
        if (this.balance> amount){
            this.balance -= amount;
            this.generateTransaction(userid, amount, "Withdraw", userid, "Successfull");
            return true;
        }   
        else{
            this.generateTransaction(userid, amount, "Withdraw", userid, "Failed");
            //generate transaction failed message
            return false;
        }  
    }

    public boolean transfer(double amount, Bank account){
        if(this.balance > amount){
            this.balance -= amount;
            account.addBalance(amount);
            this.generateTransaction(this.userid, amount, "Transfer", account.userid, "Successfull");
            return true;
        }
        else{
            //generate transaction failed
            this.generateTransaction(this.userid, amount, "Transfer", account.userid, "Failed");
            account.generateTransaction(account.userid, amount, "Transfer", this.userid, "Failed");
            return false;
        }
    }

    public void generateTransaction(int userid, double amount, String type, int target, String Status){
        long ref_no =(long) (Math.random() * Math.pow(10, 10));
        String message = "Ref.no: " + ref_no + " user id : " + userid + " target : " + target + " amount: " + amount + " type : " + type + " Status : " + Status;
        this.updateTransaction(message);
    }

    public void updateTransaction(String transaction){
        transactions_list.add(transaction);
    }

    public void showTransaction(){
        for(String transaction: this.transactions_list){
            System.out.println(transaction);
        }
    }
}
