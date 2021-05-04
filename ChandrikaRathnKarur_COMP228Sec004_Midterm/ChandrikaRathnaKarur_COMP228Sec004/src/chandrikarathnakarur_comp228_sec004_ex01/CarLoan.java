//Chandrika Rathna Karur
//Student ID: 301163364


package chandrikarathnakarur_comp228_sec004_ex01;

//importing dependencies
import java.util.Date;

public class CarLoan extends Loan{

	private double insuranceAmount;
	private double monthlyLoanAmount;
	private double time;
	
	//constructor
	public CarLoan(String customerName, Date customerDOB, String address, double loanAmount, double rateOfInterest, double insuranceAmount, double time)
	{
		super(customerName, customerDOB, address, loanAmount, rateOfInterest);
		if(insuranceAmount<=0)
			throw new IllegalArgumentException("Insurance Amount should be > 0.00");
		this.insuranceAmount=insuranceAmount;
		if(time<=0)
			throw new IllegalArgumentException("Time should be > 0.00 Years");
		this.time=time;
		
	}
	
	//setter for car loan
	public void setCarLoan(String customerName, Date customerDOB, String address, double loanAmount, double rateOfInterest, double insuranceAmount, double time)
	{
		
		this.setLoan(customerName, customerDOB, address, loanAmount, rateOfInterest);
		if(insuranceAmount<=0)
			throw new IllegalArgumentException("Insurance Amount should be > 0.00");
		this.insuranceAmount=insuranceAmount;
		if(time<=0)
			throw new IllegalArgumentException("Time should be > 0.00 Years");
		this.time=time;
	}
	
	//getters for all the instance variables
	public double getInsuranceAmount()
	{
		return this.insuranceAmount;
	}

	//getters for all the instance variables
	public double getRateOfInterest()
	{
		return this.rateOfInterest;
	}
	
	//getter for time
	public double getTime()
	{
		return this.time;
	}
	
	//overriding the method for calculating the loan amount
	public double calculateMonthlyLoanInstallment() 
	{
		this.loanAmount=super.getLoanAmount();
		double interestAmount= (this.loanAmount*this.rateOfInterest*this.time)/100;
		this.monthlyLoanAmount=(interestAmount+this.loanAmount)/(this.time*12)+(this.insuranceAmount);
		return this.monthlyLoanAmount;
		}
		
	//override toString method
	@Override
	public String toString()
	{
		return String.format("\n======================\n%s Car Loan Details:\n======================\n\n%s\nCar Loan Time Duration of: %.2f Years\nMonthly Loan Installment: $%.2f\n\n========================\n", this.getCustomerName(),super.toString(), this.getTime(), this.calculateMonthlyLoanInstallment());

	}
	
}//end of class car loan
