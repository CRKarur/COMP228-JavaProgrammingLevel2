package chandrikarathnakarur_sec004_ex01;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

	public static void main(String[] args) throws InterruptedException {
	
		AccountBuffer SyncAccount = new SynchronizedAccount();

		Account account1 = new Account("Account1", 50.00);
	    Account account2 = new Account("Account2", 150.00); 

	    
	    Transaction transaction1=new Transaction(SyncAccount, account1,"Withdraw",20.00);
	    Transaction transaction2=new Transaction(SyncAccount, account2,"Deposit",10.00);
	    Transaction transaction3=new Transaction(SyncAccount, account1,"Deposit",10.00);
	    Transaction transaction4=new Transaction(SyncAccount, account2,"Withdraw",20.00);
	    
	    
	   ExecutorService executorService=Executors.newCachedThreadPool();//thread pool
	   
	   executorService.execute(transaction1);
	   executorService.execute(transaction2);
	   executorService.execute(transaction3);
	   executorService.execute(transaction4);
	   
	   executorService.shutdown();
	   } // end main

	}


