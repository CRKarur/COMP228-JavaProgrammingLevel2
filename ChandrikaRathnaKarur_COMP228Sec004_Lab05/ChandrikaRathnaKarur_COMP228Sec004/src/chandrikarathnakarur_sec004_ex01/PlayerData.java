package chandrikarathnakarur_sec004_ex01;

public class PlayerData {
	
	 String playerID;
	 String firstName;
	 String lastName;
	 String address;
	 String postalCode;
	 String province;
	 String phoneNumber;
	 
	 public PlayerData(String playerID, String firstName,String lastName, String address, String postalcode, String province, String phone)
	 {
		 this.playerID=playerID;
		 this.firstName=firstName;
		 this.lastName=lastName;
		 this.address=address;
		 this.postalCode=postalcode;
		 this.province=province;
		 this.phoneNumber=phone; 
	 }

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
