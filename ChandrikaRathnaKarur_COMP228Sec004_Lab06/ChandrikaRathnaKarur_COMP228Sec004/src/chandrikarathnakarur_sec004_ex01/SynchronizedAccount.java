package chandrikarathnakarur_sec004_ex01;

public class SynchronizedAccount implements AccountBuffer {

	private Account BufferAccount = null; // shared by different transaction threads
	private boolean occupied = false;
	
	public synchronized void blockingPutAccount(Account IAccount) throws InterruptedException {
		// TODO Auto-generated method stub
		while (occupied) {
		   wait();
		}
		BufferAccount = IAccount; // set new buffer value
		occupied = true; 
		notifyAll();
	}

	@Override
	public synchronized Account blockingGetAccount() throws InterruptedException {
        while (!occupied) {
        	wait();
        }
        occupied = false;
        notifyAll();
        return BufferAccount;
	}
     
}
