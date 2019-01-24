/**
 * Created by jargonaut on 10/24/18.
 */
public class Bank_Test {
    private Bank testBank;

    public Bank_Test(){
        testBank = new Bank("testBank");
    }

    private boolean testBank(){

        return true;
    }

    private boolean testAccount() {
        Account testAccount;
        testAccount = new Account("Joe", 1000000, false );

        if (!testAccount.getOwner().contentEquals("Joe")){
            System.out.println("getOwner() failed");
            return false;
        }
        if (testAccount.isCorporate()){
            System.out.println("isIndividual() failed");
            return false;
        }
        if(testAccount.getBalance() != 1000000){
            System.out.println("getBalance() failed");
            return false;
        }
        testAccount.deposit(100000);
        testAccount.withdraw(500000);
        testAccount.withdraw(500000);
        if (testAccount.getBalance() != 100000){
            System.out.println("withdraw() or deposit() failed");
            return false;
        }
        testAccount.accumulateDays();
        testAccount.accumulateDays(300);
        if(testAccount.getAccountDays() != 301){
            System.out.println("accumulateDays() failed");
            return false;
        }
        return true;
    }

    private boolean testChecking_Account(){
        return true;
    }

    private boolean testInvestment_Account(){
        return true;
    }

    private boolean testAll(){
        return true;
    }

    public static void main(String[] args) {
        Bank_Test test = new Bank_Test();
        System.out.println(test.testAccount());
    }

}
