//Chandrika Rathna Karur
//Student ID: 301163364


package chandrikarathnakarur_comp228_sec004_ex01;

//importing dependencies
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class LoanTest {



	public static void main(String[] args)
	{
		Scanner myinput = null;
		myinput=new Scanner(System.in);

		Date customerDOB = new Date();
		String customerDOB_string = null;
		System.out.printf("\n**Welcome to open a new Loan Account**\n");
		System.out.printf("\nEnter Customer Name: ");
		String customerName=myinput.nextLine();
		System.out.printf("\nEnter Customer DOB in format dd/MM/yyyy: ");
		try {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.CANADA);
		customerDOB_string=myinput.nextLine();
		customerDOB = format.parse(customerDOB_string);
		} catch(ParseException e) {
			e.printStackTrace();
		} 
		System.out.println(customerDOB_string+"\t"+customerDOB);
		Address address=new Address();
		address.setAddress();//calling setter of the address class
		String address1=address.toString();//storing the address in a string format using toString method from Address class
	
			System.out.printf("\n****%s Mortgage Loan****", customerName);
			System.out.printf("\nEnter Loan Time/Duration in Years: ");
			double time=myinput.nextDouble();
			System.out.printf("\nEnter Loan Amount for %.2fYears: $",time);
			double loanAmount=myinput.nextDouble();
			System.out.printf("\nEnter Rate of Interest > 0.0 and < 5.0: ");
			double rateOfInterest=myinput.nextDouble();
			System.out.printf("\nEnter Property Tax Amount/year: $");
			double propertyTax=myinput.nextDouble();
			System.out.printf("\nEnter Infrastructure Tax Amount/month: $");
			double infrastructureTax=myinput.nextDouble();
			//creating a Mortgage Loan object
			MortgageLoan mortgageLoan=new MortgageLoan(customerName, customerDOB, address1, loanAmount, rateOfInterest, propertyTax, infrastructureTax, time);
			System.out.printf(mortgageLoan.toString());
	
			
			
			System.out.printf("\n****%s Car Loan****", customerName);
			System.out.printf("\nEnter Loan Time/Duration in Years: ");
			time=myinput.nextDouble();
			System.out.printf("\nEnter Loan Amount for %.2f Years: $",time);
			loanAmount=myinput.nextDouble();
			System.out.printf("\nEnter Rate of Interest > 0.0 and < 5.0: ");
			rateOfInterest=myinput.nextDouble();
			System.out.printf("\nEnter Insurance Amount/month: $");
			double insuranceAmount=myinput.nextDouble();
			//creating a Car Loan object
			CarLoan carLoan=new CarLoan(customerName, customerDOB, address1, loanAmount, rateOfInterest, insuranceAmount, time);
			System.out.printf(carLoan.toString());
		//}	
			myinput.close();
			
			System.out.printf("\n Displaying Polymorphic behavior using Loan Super Class");
		//displaying polymorphism
		//creating 2 objects of Loan class
			Loan[] loan= new Loan[2];
		
			//initializing array with 2 objects fo subclass
			loan[0]=mortgageLoan;
			loan[1]=carLoan;
			
			
			//generically processing each element in array loan
			for(Loan currentLoan : loan)
			{
				System.out.println(currentLoan);//invokes toString
			}
			
			//using for loop on loan array to display the class of each array
			for(int i=0;i<loan.length;i++)
			{
				System.out.printf("\nLoan[%d] is a %s \n=============================\n\n",i,loan[i].getClass().getName());
			}
			

	}//end of void main()
}//end of class test
