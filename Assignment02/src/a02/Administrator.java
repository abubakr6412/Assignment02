package a02;

public class Administrator {

	private String Username="AbuBakr6412";
	private String Password="6412";
	private int EmpID=53;
	
	
//	public Administrator(String User,String Pass,int EMPID) {
//		setUsername(User);
//		setPassword(Pass);
//		setEmpID(EMPID);
//	}
	public boolean login(String user,String pass) {
		
		
		if(Username.equals(user) && Password.equals(pass)) {
			return true;
		}
		else {
			
			return false;
		}
		
		
	}


	public int getEmpID() {
		return EmpID;
	}


	public void setEmpID(int empID) {
		EmpID = empID;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}
	
}
