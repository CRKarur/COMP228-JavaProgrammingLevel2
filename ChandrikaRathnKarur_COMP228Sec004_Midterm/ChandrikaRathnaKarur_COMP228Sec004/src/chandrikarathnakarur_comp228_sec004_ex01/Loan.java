//Chandrika Rathna Karur
//Student ID: 301163364
//Abstract Class Loan


package chandrikarathnakarur_comp228_sec004_ex01;

//importing dependencies
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.text.DateFormat;  

//defining abstract class Loan
public abstract class Loan{
	
	//declaring instant variables
	private final int loanNumber;
	private String customerName;
	private Date customerDOB= new Date();
	private String address=null;
	protected double loanAmount=0.0;
	protected double rateOfInterest=0.0;
	
	//Constructor using 3 instance variables
	public Loan(String customerName, Date customerDOB, String address)
	{
		this.loanNumber=10000+(new Random().nextInt(90000));
		this.customerName=customerName;
		this.customerDOB=customerDOB;
		this.address=address;
		this.loanAmount=0.0;
	}
	
	//Constructor using all the instance variables
	public Loan(String customerName, Date customerDOB, String address, double loanAmount, double rateOfInterest)
	{
		//initializing loan number to randomly generate a number
		this.loanNumber=10000+(new Random().nextInt(90000));
		this.customerName=customerName;
		this.customerDOB=customerDOB;
		this.address=address;
		if(loanAmount<=0.0)
			throw new IllegalArgumentException("\nLoan Amount should be > 0.00");//exception if loan amount is <=0
		this.loanAmount=loanAmount;
		if(rateOfInterest<=0.0)
			throw new IllegalArgumentException("\nInterest rate should be > 0.00%");//exception if rate of interest is <0
		if(rateOfInterest>5.0)
			throw new IllegalArgumentException("\nInterest rate should be < 5.0%");//exception if rate of interest is >5
		this.rateOfInterest=rateOfInterest;
	}
	
	//Setter for all instance variables at once
	public void setLoan(String customerName, Date customerDOB, String address, double loanAmount, double rateOfInterest)
	{
		this.customerName=customerName;
		this.customerDOB=customerDOB;
		this.address=address;
		if(loanAmount<=0.0)
			throw new IllegalArgumentException("\nLoan Amount should be > 0.00");//exception if loan amount is <0
		this.loanAmount=loanAmount;
		if(rateOfInterest<=0.0)
			throw new IllegalArgumentException("\nInterest rate should be > 0.00%");//exception if rate of interest is <0
		if(rateOfInterest>5.0)
			throw new IllegalArgumentException("\nInterest rate should be < 5.0%");//exception if rate of interest is >5
		this.rateOfInterest=rateOfInterest;
	}

	
	//getter for loan number
	public int getLoanNumber()
	{
		return this.loanNumber;
	}
	
	//getter for all other instance variables
	public String getCustomerName()
	{
		return this.customerName;
	}
	
	public Date getCustomerDOB() 
	{
		return this.customerDOB;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public double getLoanAmount()
	{
		return this.loanAmount;
	}
	
	//abstract method for rate of interest
	public abstract double getRateOfInterest();
	
	//abstract method for calculating Monthly Loan Installment
	public abstract double calculateMonthlyLoanInstallment();
	
	@Override
	public String toString()
	{
		DateFormat format = new SimpleDateFormat();
		format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.CANADA);
		return String.format("\nLoan Number: %d\nCustomer Name: %s\nCustomer DOB: %s %s\nLoan Amount: $%.2f\nRate of Interest: %.2f\n", 
				getLoanNumber(), getCustomerName(), format.format(getCustomerDOB()), getAddress(), getLoanAmount(), getRateOfInterest());
	}
}
