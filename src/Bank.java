import java.util.ArrayList;
/**
 * Created by Jason Argo on 10/22/18.
 * Note: Balance is stored as a long in cents to avoid round-off error existing in doubles or floats (ex. 1005 = $10.05)
 * Note: interest rate is stored in 1000ths of a percent in an integer value (ex. 5456 = 5.456%; 15000 = 15%)
 */

public class Bank {
    private String name;
    private static ArrayList<Account> accounts;
    private static ArrayList<Checking_Account> checking_accounts;
    private static ArrayList<Investment_Account> investment_accounts;

    static {
        accounts = new ArrayList<Account>();
        checking_accounts = new ArrayList<Checking_Account>();
        investment_accounts = new ArrayList<Investment_Account>();
    }

    public Bank(String name){
        this.name = name;
    }

    public class Checking_Account extends Account {
        public Checking_Account(String Owner, long Balance, boolean individual_or_corporate){
            super(Owner, Balance, individual_or_corporate);
            accounts.add(this);
            checking_accounts.add(this);
            }
        }

    public class Investment_Account extends Account {
        int interestRate;

        public Investment_Account(String Owner, long Balance, boolean individual_or_corporate, int interestRate){
            super(Owner, Balance, individual_or_corporate);
            accounts.add(this);
            investment_accounts.add(this);
        }

        public double getInterestRate(){
            return this.interestRate;
        }

        public void accumulateInterest() {
            this.deposit( this.getBalance() + (this.getBalance() * interestRate / 1000) );
        }
    }


    public String getName(){
        return this.name;
    }

    public ArrayList<Account> getAllAccounts() {
        return accounts;
    }

    public ArrayList<Checking_Account> getCheckingAccounts() {
        return checking_accounts;
    }

    public ArrayList<Investment_Account> getInvestmentAccounts() {
        return investment_accounts;
    }

    public void payAnnualInterest(){
        ArrayList<Investment_Account> a = getInvestmentAccounts();
        System.out.println(a.size());
        for (int i=0; i < a.size(); i++){
            if (a.get(i).getAccountDays() >= 365){
                a.get(i).accumulateDays(-365);
                a.get(i).accumulateInterest();
            }
        }
    }

    public boolean transfer(Account fromAccount, Account toAccount, long quantity){
        if (fromAccount.withdraw(quantity)){
            toAccount.deposit(quantity); return true; }
        else { return false; }
    }

}