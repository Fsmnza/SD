package composite_design_pattern;


import java.util.ArrayList;
import java.util.List;

abstract class Account //Account is an abstract class representing the common interface for all types of accounts
{
    public abstract float getBalance(); // It has a single abstract method getBalance() that must be implemented by subclasses
}

class DepositeAccount extends Account //DepositeAccount is concrete subclasses of Account. He represents individual accounts with account numbers and balances. This class implement the getBalance() method to return their respective account balances
{
    private String accountNo;
    private float accountBalance;

    public DepositeAccount(String accountNo, float accountBalance)
    {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance()
    {
        return accountBalance;
    }
}

class SavingAccount extends Account //SavingAccount is same as DepositeAccount. They represent individual accounts with account numbers and balances. Both classes implement the getBalance() method to return their respective account balances
{
    private String accountNo;
    private float accountBalance;

    public SavingAccount(String accountNo, float accountBalance)
    {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance()
    {
        return accountBalance;
    }
}

class CompositeAccount extends Account //CompositeAccount is a composite class that also extends Account
{
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>(); // It has a list (accountList) to hold references to other accounts

    public float getBalance() // It implements the getBalance() method by iterating through its child accounts, summing up their balances to calculate the total balance
    {
        totalBalance = 0;
        for (Account f : accountList)
        {
            totalBalance = totalBalance + f.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account acc) //addAccount() method in CompositeAccount allow we to add and remove child accounts from the composite
    {
        accountList.add(acc);
    }

    public void removeAccount(Account acc) //removeAccount is the like assAccount. The both methods in CompositeAccount allow we to add and remove child accounts from the composite.
    {
        accountList.add(acc);
    }
}

public class CompositePattern //we create a CompositeAccount named component.
{
    public static void main(String[] args)
    {
        CompositeAccount component = new CompositeAccount();

        component.addAccount(new DepositeAccount("DA001", 100));
        component.addAccount(new DepositeAccount("DA002", 150));
        component.addAccount(new SavingAccount("SA001", 200));
        //we add three accounts (two DepositeAccount instances and one SavingAccount instance) to the component using the addAccount() method

        float totalBalance = component.getBalance(); //we calculate the total balance of the composite account by calling getBalance() on component
        System.out.println("Total Balance : " + totalBalance);//finally, we print out the total balance
    }
}
