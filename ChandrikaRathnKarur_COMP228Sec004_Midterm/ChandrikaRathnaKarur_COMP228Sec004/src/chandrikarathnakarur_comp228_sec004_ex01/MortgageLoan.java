//Chandrika Rathna Karur
//Student ID: 301163364


package chandrikarathnakarur_comp228_sec004_ex01;

//importing dependencies
import java.util.Date;

public class MortgageLoan extends Loan{

	private double propertyTax;
	private double infrastructureTax;
	private double monthlyLoanAmount;
	private double time;
	
	//constructors
	public MortgageLoan(String customerName, Date customerDOB, String address, double loanAmount, double rateOfInterest, double propertyTax, double infrastructureTax, double time)
	{
		super(customerName, customerDOB, address, loanAmount, rateOfInterest);
		if(propertyTax<=0)
			throw new IllegalArgumentException("Property Tax should be > 0.00");
		this.propertyTax=propertyTax;
		if(infrastructureTax<=0)
			throw new IllegalArgumentException("Monthly Infrastructure Tax should be > 0.00");
		this.infrastructureTax=infrastructureTax;
		if(time<=0)
			throw new IllegalArgumentException("Loan Time  should be > 0 year");
		this.time=time;
		
	}
	
	//Setter for Mortgage
	public void setMortgageLoan(String customerName, Date customerDOB, String address, double loanAmount, double rateOfInterest, double propertyTax, double infrastructureTax, double time)
	{
		this.setLoan(customerName, customerDOB, address, loanAmount, rateOfInterest);
		if(propertyTax<=0)
			throw new IllegalArgumentException("Property Tax should be > 0.00");
		this.propertyTax=propertyTax;
		if(infrastructureTax<=0)
			throw new IllegalArgumentException("Infrastructure Tax should be > 0.00");
		this.infrastructureTax=infrastructureTax;	
		if(time<=0.0)
			throw new IllegalArgumentException("\time should be > 0 Years");
		this.time=time;
	}
	
	//getters for property tax
	public double getPropertyTax()
	{
		return this.propertyTax;
	}
	
	//getters for infrastructure tax
	public double getinfrastructureTax()
	{
		return this.infrastructureTax;
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
	
	//overriding getter for rate of interest
	/*public double getRateOfInterest()
	{
		return this.rateOfInterest;
	}*/
	
	//overriding the method for calculating the loan amount
	public double calculateMonthlyLoanInstallment() 
	{
		this.loanAmount=super.getLoanAmount();
		double interestAmount= (this.loanAmount*this.rateOfInterest*this.time)/100;
		this.monthlyLoanAmount=(interestAmount+this.loanAmount)/(this.time*12)+(this.propertyTax/12)+this.infrastructureTax;
		return this.monthlyLoanAmount;
	}
	
	//override toString method
	@Override
	public String toString()
	{
		return String.format("\n======================\n%s Mortgage Loan Details:\n======================\n\n%s\nMortgage Loan Time Duration: %.2f Years\nMonthly Loan Installment: %.2f\n\n========================\n", this.getCustomerName(), super.toString(), this.getTime(), this.calculateMonthlyLoanInstallment());
	}
	}//end of class mortagage loan
