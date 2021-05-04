package chandrikarathnakarur_sec004_ex01;

public class studentDataSet {
    private String StudentID;
    private String FirstName;
    private String LastName;
    private String Address;
    private String City;
    private String Province;
    private String PostalCode;
    
    public studentDataSet (String StudentID, String FirstName, String LastName, String Address, String City, String Province, String PostalCode) {
        this.StudentID = StudentID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.City = City;
        this.Province = Province;
        this.PostalCode = PostalCode;
    }

    public String getStudentID () {
        return this.StudentID;
    }

    public String getFirstName () {
        return this.FirstName;
    }

    public void setStudentID (String StudentID) {
        this.StudentID=StudentID;
    }

    public void setFirstName (String FirstName) {
        this.FirstName=FirstName;
    }

	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getProvince() {
		return this.Province;
	}

	public void setProvince(String Province) {
		this.Province = Province;
	}

	public String getCity() {
		return this.City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getPostalCode() {
		return this.PostalCode;
	}

	public void setPostalCode(String PostalCode) {
		this.PostalCode = PostalCode;
	}
}
