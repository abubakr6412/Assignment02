package a02;




public class Customer {

	private String Name;
	private String Gender;
	private int Age;
	private String Address;
	private int PassportNum;
	private String FlightID;
	private int SeatNo;
	
	private String Origin,Destination;
	
	
	int min = 0;
    int max = 100;
    
	private int PassID;

	
	
	public Customer(String n,String g,int a,String aadr,int ppnb,String og,String dst,String ftype,int PID,int SeatN) {
		Name=n;
		Gender=g;
		Age=a;
		Address=aadr;
		PassportNum=ppnb;
		Origin=og;
		Destination=dst;
		FlightID=ftype;
		PassID=PID;
		SeatNo=SeatN;
		
	}
	public void setrandSeat() {
		PassID=(int)Math.floor(Math.random()*(max-min+1)+min);
	}
	public String getName() {
		return Name;
	}
	public void removeData() {
		Name=null;
		Gender=null;
		Age=0;
		Address=null;
		PassportNum=0;
		Origin=null;
		Destination=null;
		FlightID=null;
		PassID=0;
		SeatNo=0;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPassportNum() {
		return PassportNum;
	}

	public void setPassportNum(int passportNum) {
		PassportNum = passportNum;
	}

	public String getOrigin() {
		return Origin;
	}

	public void setOrigin(String origin) {
		Origin = origin;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	
	public int getPassID() {
		return PassID;
	}
	public void setPassID(int passID) {
		PassID = passID;
	}


	
	public void PrintINFO() {
		System.out.println("\r\n"+Name+"\r\n"+Gender+"\r\n"+Age+"\r\n"+Address+"\r\n"+PassportNum+"\r\n"+Origin+"\r\n"+Destination+"\r\n"+FlightID+"\r\n"+PassID+"\r\n"+SeatNo);	
	}
	
	public void PrintTicket(Flight FLT) {
		System.out.println("Ticket:");
		System.out.println("Name: "+Name+" PassportNum: "+PassportNum+" FlightID: "+FlightID+"\r\n"+ "Origin: "+Origin+" Destination: "+Destination+ " SeatNo: "+SeatNo);
		System.out.println("Date: "+FLT.getFlightDate()+" Time: "+FLT.getTime());
		
		
	}
	public String getFlightID() {
		return FlightID;
	}
	public void setFlightID(String flightID) {
		FlightID = flightID;
	}
	public int getSeatNo() {
		return SeatNo;
	}
	public void setSeatNo(int seatNo) {
		SeatNo = seatNo;
	}
	
}
