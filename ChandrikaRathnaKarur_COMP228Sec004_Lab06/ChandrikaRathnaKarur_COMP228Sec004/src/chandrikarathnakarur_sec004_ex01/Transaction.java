package chandrikarathnakarur_sec004_ex01;

import java.security.SecureRandom;

public class Transaction implements Runnable {

	private  static final SecureRandom generator = new SecureRandom();
	private final int sleepTime;
	private final String transactionName;
	private double amount;
	private Account account;
	private final AccountBuffer SyncAccount;

	//constructor
	public Transaction(AccountBuffer SyncAccount, Account account, String transactionName, double amount)
	{
		this.SyncAccount = SyncAccount;
		this.transactionName=transactionName;
		this.amount=amount;
		this.account=account;
		sleepTime=generator.nextInt(5000);//milliseconds
	}//end of constructor
	
	public String getTransactionName()
	{
		return this.transactionName;
	}

	public double getAmount()
	{
		return this.amount;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(sleepTime);//put thread to sleep
			SyncAccount.blockingPutAccount(account);//blocks the account for a transaction
			if(transactionName=="Withdraw")
			{
				this.account.withdraw(this.amount);
				System.out.printf("\n%s %s %.2f > New Balance: %.2f",account.getName(),this.getTransactionName(), this.getAmount(), account.getBalance());
				
			}//end of if condition for withdraw
			if(transactionName=="Deposit")
			{
				this.account.deposit(amount);
				System.out.printf("\n%s %s %.2f > New Balance: %.2f",account.getName(),this.getTransactionName(), this.getAmount(), account.getBalance());
			}
			SyncAccount.blockingGetAccount();//releases the account after the transaction
		}//end of try block
		catch(InterruptedException exception) {
			exception.printStackTrace();
			Thread.currentThread().interrupt();//re-interrupt the thread
		}//end of catch block
		}//end of run method
		
	}//end of Transaction class
