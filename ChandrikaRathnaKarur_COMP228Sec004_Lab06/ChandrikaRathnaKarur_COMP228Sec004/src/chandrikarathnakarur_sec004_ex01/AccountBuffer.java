package chandrikarathnakarur_sec004_ex01;

public interface AccountBuffer {
	public void blockingPutAccount(Account IAccount) throws InterruptedException;
	public Account blockingGetAccount() throws InterruptedException;
}
