//Chandrika Rathna Karur
//Student ID: 301163364

package chandrikarathnakarur_comp228_sec004_ex01;

//importing dependencies
import java.util.Scanner;

public class Address {
	
	private int houseNumber;
	private String streetName;
	private String city;
	private String zipCode;
	Scanner input=new Scanner(System.in);
	
	//constructors
	public Address()
	{
		//default constructor
	}
	public Address(int houseNumber, String streetName, String city, String zipCode)
	{
		this.houseNumber=houseNumber;
		this.streetName=streetName;
		this.city=city;
		this.zipCode=zipCode;
	}
	
	//setter for address
	public void setAddress()
	{
		
		System.out.printf("\nEnter house Number: ");
		this.houseNumber=Integer.parseInt(input.nextLine());
		System.out.printf("\nEnter Street name: ");
		this.streetName=input.nextLine();
		System.out.printf("\nEnter City: ");
		this.city=input.nextLine();
		System.out.printf("\nEnter zipcode: ");
		this.zipCode=input.nextLine();
	}
	
	//getters for address
	public int getHouseNumber()
	{
		return this.houseNumber;
	}
	
	public String getStreetName()
	{
		return this.streetName;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public String getZipCode()
	{
		return this.zipCode;
	}
	
	//override method toString
	@Override
	public String toString()
	{
		return String.format("\nAddress: %d, %s, %s, %s.", getHouseNumber(), getStreetName(), getCity(), getZipCode());
	}
	
	
}//end of class Account
