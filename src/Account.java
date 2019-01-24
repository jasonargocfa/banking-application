/**
 * Created by jargonaut on 10/23/18.
 */
public class Account {
    private String Owner;
    private long Balance;
    private int account_days = 0;
    private boolean corporate;

    public Account(String Owner, long Balance, boolean individual_or_corporate) {
        this.Owner = Owner;
        this.Balance = Balance;
        this.corporate = individual_or_corporate;
    }

    public String getOwner(){
        return this.Owner;
    }

    public long getBalance(){
        return this.Balance;
    }

    public boolean isCorporate(){
        return this.corporate;
    }

    public int getAccountDays(){
        return this.account_days;
    }

    public void accumulateDays(int days) {
        account_days += days;
    }

    public void accumulateDays() {
        account_days += 1;
    }

    public boolean canWithdraw(long withdraw_quantity){
        if (withdraw_quantity > Balance){ return false; }
        else if (!corporate && (Balance - withdraw_quantity) < 50000){ return false; }
        else { return true; }
    }

    public void deposit(long deposit_quantity){
        Balance += deposit_quantity;
    }

    public boolean withdraw(long withdraw_quantity){
        if (!canWithdraw(withdraw_quantity)){ return false; }
        else { Balance -= withdraw_quantity; return true; }
    }

}