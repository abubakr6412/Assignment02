package a02;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


class InvalidInput  extends Exception  
{  
    public InvalidInput (String str)  
    {  
       
        super(str);  
    }  
}  


class UserPass extends Exception  
{  
    public UserPass (String str)  
    {  
       
        super(str);  
    }  
}  

class PASSID extends Exception  
{  
    public PASSID (String str)  
    {  
       
        super(str);  
    }  
}  





public class AirlineTicketSys {
	
	
	public Flight[] PopulateFlights() throws IOException {
		Flight[] FLT;
		FLT=new Flight[50];
		
		List<String> list = Files.readAllLines(new File("Flights.txt").toPath(), Charset.defaultCharset() );
	
		for(int i=0;i<list.size();i++) {
			List<String> items = Arrays.asList(list.get(i).split("\\s*,\\s*"));
			FLT[i]=new Flight(items.get(0), items.get(1), items.get(2), items.get(3),items.get(4),Integer.parseInt(items.get(5)),Integer.parseInt(items.get(6)),items.get(7));
		}

		
		
		return FLT;
	
	}
	
	public Customer[] PopulateCustomers() throws IOException{
		Customer[] CST;
		CST=new Customer[100];
		
		

		List<String> list = Files.readAllLines(new File("Customers.txt").toPath(), Charset.defaultCharset() );

		for(int i=0;i<list.size();i++) {
			List<String> items = Arrays.asList(list.get(i).split("\\s*,\\s*"));
			CST[i]=new Customer(items.get(0), items.get(1), Integer.parseInt(items.get(2)), items.get(3),  Integer.parseInt(items.get(4)),items.get(5),items.get(6), items.get(7),  Integer.parseInt(items.get(8)),  Integer.parseInt(items.get(9)));
			
			
			String Name=items.get(0);
			String Gender=items.get(1);
			int Age=Integer.parseInt(items.get(2));
			String Address=items.get(3);
			int PassportNum=Integer.parseInt(items.get(4));
			String Origin=items.get(5);
			String Destination=items.get(6);
			String FlightID=items.get(7);
			int PassID=Integer.parseInt(items.get(8));
			int SeatNo=Integer.parseInt(items.get(9));
		
		}
		
		
		return CST;
		
	}
	
	public void FillPassengers(Flight FLT[] ,Customer CUST[]) {
		
		
		for(int i=0;CUST[i]!=null;i++) {
			for(int j=0;FLT[j]!=null;j++) {
				if(CUST[i].getFlightID().equals(FLT[j].getFlightName())) {
					
					
					FLT[j].PassengersID_Status[CUST[i].getSeatNo()]=CUST[i].getPassID();
					FLT[j].SeatStatus[CUST[i].getSeatNo()]=2;
					
				}
			}
			
			
		}
		
		
	}
	
	

	
	
	
	
	
	
	

	public static void main(String[] args) throws InvalidInput, UserPass, PASSID{
	//	Customer Cust = new Customer(null, null, 0, null, 0, null, null, null);
		//Cust.setName("AbuBakr Humayun");
		//Object[] objectArray = new Object[3];
		//System.out.println(System.getProperty("user.dir"));
		//Populating Flights and INFO------------------------------
	
		//-------------------------------
		AirlineTicketSys sys=new AirlineTicketSys();
		
		Flight[] FLT;
		
	FLT=new Flight[50];
	try {
		FLT=sys.PopulateFlights();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	Customer[] CST;
	CST=new Customer[100];
	
	try {
		CST=sys.PopulateCustomers();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		

	sys.FillPassengers(FLT, CST);
	
	
	
	
		

	
		
		System.out.println("Welcome to AbuBakr's Flight Reservation System...");
		System.out.println("->To schedule a new flight enter 1.");
		System.out.println("->If you already have a booking enter 2.");
		System.out.println("->To exit the FRS enter 3.");
		System.out.println();
		System.out.println();
		System.out.println("FOR UNLIMITED POWER ENTER -1(ADMIN MODE)");
		
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter you choice: ");
		int option = reader.nextInt();
		
		if(option!=-1 && option!=2 && option!=3 && option!=1) {
			
			  throw new InvalidInput("Input option selected is incorrect");
		}
		
		
		if(option==-1) {
			Administrator admin=new Administrator();
			System.out.println("Enter your Username:");
			Scanner us= new Scanner(System.in); //System.in is a standard input stream  
			String username= us.nextLine();              //reads string
			System.out.println("Enter your Password:");
			Scanner psd= new Scanner(System.in); //System.in is a standard input stream  
			String password= psd.nextLine(); 
			
			if(admin.login(username, password)) {
				System.out.println("Logged in Successfully");
				System.out.println("Welcome: "+admin.getUsername());
				
				System.out.println("To Enter A New Flight 1");
				System.out.println("To View Bookings 2");
				System.out.println("To View All Scheduled Flights 3");
				System.out.println("To View Specifc Booking 4");
				System.out.println("Enter your option:");
				Scanner adminopt= new Scanner(System.in); //System.in is a standard input stream  
				int adminoption=adminopt.nextInt(); 
				
				if(adminoption!=1 && adminoption!=2 && adminoption!=3 && adminoption!=4) {
					 throw new InvalidInput("Input option selected by admin is incorrect");
				}
				
				if(adminoption==1) {
					System.out.println("Enter FlightID:");
					Scanner adminopt5= new Scanner(System.in); //System.in is a standard input stream  
					String FLNAME=adminopt5.nextLine(); 
					System.out.println("Enter Origin:");
					String Origin=adminopt5.nextLine();
					System.out.println("Enter Destination:");
					String Dest=adminopt5.nextLine();
					System.out.println("Enter Date:");
					String date=adminopt5.nextLine();
	
					System.out.println("Enter Plane Type:");
					String enterPtype=adminopt5.nextLine();
					System.out.println("Enter Economy Cost:");
					int ecocost=adminopt5.nextInt();
					System.out.println("Enter VIP cost:");
					int vipcost=adminopt5.nextInt();
					
					Scanner adminopt6= new Scanner(System.in); //System.in is a standard input stream  
					System.out.println("Enter Departure Time:");
					String Dtime=adminopt6.nextLine();
					
					for(int i=0;i<50;i++) {
						if(FLT[i]==null) {
							FLT[i]=new Flight(FLNAME,Origin,Dest,date,enterPtype,ecocost,vipcost,Dtime);
							
							System.out.println("Successfully added:");
							FLT[i].PRINTINFO();
							
							break;
						}
						
					}
					
					
				}
				if(adminoption==2) {
					System.out.println("Enter FlightID:");
					Scanner adminopt2= new Scanner(System.in); //System.in is a standard input stream  
					String FNAME=adminopt2.nextLine(); 

					for(int i=0;FLT[i]!=null;i++) {
						if(FLT[i].getFlightName().equals(FNAME)) {
							System.out.println("Economy Bookings:");
							FLT[i].EconomyPrint();
							System.out.println("VIP Bookings:");
							FLT[i].VIPPrint();
						}
						
					}
					
				}
				if(adminoption==3) {
					System.out.println("Complete flight schedule:");
					
					for(int i=0;FLT[i]!=null;i++) {
						FLT[i].PRINTINFO();
					}
				}
				
				if(adminoption==4) {
					System.out.println("Enter Passenger ID:");
					Scanner adminopt4= new Scanner(System.in); //System.in is a standard input stream  
					int PID=adminopt4.nextInt(); 
					
					for(int i=0;CST[i]!=null;i++) {
						if(CST[i].getPassID()==PID) {
							CST[i].PrintINFO();
						}
					}
				}
			}
			else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("Login info is incorrect");
				throw new UserPass("Username and Password are incorrect");
			}
		
			option=3;
		}
		
		if(option==1) {
			System.out.println("Enter your Name:");
			Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
			String Name= sc.nextLine();              //reads string
			System.out.println("Enter your Gender:");
			Scanner sc1= new Scanner(System.in); //System.in is a standard input stream  
			String Gender= sc1.nextLine(); 
			System.out.println("Enter your Age:");
			Scanner sc2= new Scanner(System.in); //System.in is a standard input stream  
			int Age= sc2.nextInt(); 
			System.out.println("Enter your Address:");
			Scanner sc3= new Scanner(System.in); //System.in is a standard input stream  
			String Address= sc3.nextLine(); 
			System.out.println("Enter your Passport Number:");
			Scanner sc4= new Scanner(System.in); //System.in is a standard input stream  
			int PassportNum= sc4.nextInt(); 
			System.out.println("Enter your Origin:");
			Scanner sc5= new Scanner(System.in); //System.in is a standard input stream  
			String Origin= sc5.nextLine(); 
			System.out.println("Enter your Destination:");
			Scanner sc6= new Scanner(System.in); //System.in is a standard input stream  
			String Destination= sc6.nextLine(); 
			
			
			System.out.println("Confirm your Information:"+"\r\n"+Name+"\r\n"+Gender+"\r\n"+Age+"\r\n"+Address+"\r\n"+PassportNum+"\r\n"+Origin+"\r\n"+Destination);
			Scanner reader1 = new Scanner(System.in);  // Reading from System.in
			System.out.println("To Confirm Enter 1...");
			int confirm = reader1.nextInt();
				
			
			if(confirm!=1) {
				option=3;
			}
			
			if(confirm==1) {
				System.out.println("Storing your Information in the System"+"\r\n"+"Please Wait...");
				try {
					TimeUnit.SECONDS.sleep((long) 1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				System.out.println("Information Successfully stored"+"\r\n"+"Proceeding...");
				Customer Cust = new Customer(Name, Gender, Age, Address, PassportNum, Origin, Destination, null,0,0);
				Cust.setrandSeat();
				
				
				
				
				
				System.out.println("For Future Refernce your Passenger ID is "+ Cust.getPassID());
				
				
				
				System.out.println("Kindly enter your travel date: (18/2/21 e.g)");
				Scanner sc8=new Scanner(System.in);
				String Fdate=sc8.nextLine();
			
				
				System.out.println("Available Flights according to your requirements");
				int counter=0;
				for(int i=0;FLT[i]!=null;i++) {
					if(FLT[i].getOrigin().equals(Cust.getOrigin()) && FLT[i].getDestination().equals(Cust.getDestination())) {
						counter++;
						System.out.print(counter+".");
						FLT[i].PRINTINFO();
						System.out.println("\r\n");
					}
				}
				System.out.println("Cheapest flight of the day:");
				try {
					System.out.println(FLT[1].CheapestDate(FLT, Fdate,Cust.getOrigin(), Cust.getDestination()).getFlightName());
				} catch (DateNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				System.out.println("Enter the flight name you would like to book:");
				Scanner sc7= new Scanner(System.in); //System.in is a standard input stream  
				String flightbook= sc7.nextLine(); 
				
				
				System.out.println("For Economy Class Enter 1"+"\r\n"+"For VIP Class Enter 2" );
				Scanner reader2 = new Scanner(System.in);  // Reading from System.in
				int seattype=reader2.nextInt();
				
				System.out.println("For Economy 0-29"+"\r\n"+"For VIP 30-50" );
				
				System.out.println("Enter Preferred Seat Number:");
				Scanner reader21 = new Scanner(System.in);  // Reading from System.in
				int seatnum=reader21.nextInt();
				
				
				System.out.println("Proceeding to Payemnt"+"\r\n"+"Then Booking Process will continue");
				System.out.println("For Cash Press 1,For Card Press 2");
				Scanner payment = new Scanner(System.in);  // Reading from System.in
				int paymenttype=payment.nextInt();
				
				
				
				
				for(int i=0;FLT[i]!=null;i++) {
					if(FLT[i].getFlightName().equals(flightbook)) {
					
						if(seattype==1) {
							if(paymenttype==1) {
								System.out.println("Please Deposit:");
								System.out.println(FLT[i].getFlightFareEco());
							
								
								System.out.println("Your deposit has been verified.");
							}
							if(paymenttype==2) {
								System.out.println("Please Input Card Num:");
								
								Scanner cardnum = new Scanner(System.in);  // Reading from System.in
								int cardnum1=payment.nextInt();
								
								System.out.println("Card Successfully Charged Rs"+ FLT[i].getFlightFareEco());
							}
							try {
								FLT[i].Economybooking(Cust.getPassID(),seatnum);
							} catch (EcoBookingError e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Cust.setFlightID(FLT[i].getFlightName());
							Cust.setSeatNo(seatnum);
							System.out.println("Seat Successfully Booked...");
							
							Cust.PrintTicket(FLT[i]);
							
						}
						if(seattype==2) {
							if(paymenttype==1) {
								System.out.println("Please Deposit:");
								System.out.println(FLT[i].getFlightFareVIP());
							
								
								System.out.println("Your deposit has been verified.");
							}
							if(paymenttype==2) {
								System.out.println("Please Input Card Num:");
								
								Scanner cardnum = new Scanner(System.in);  // Reading from System.in
								int cardnum1=payment.nextInt();
								
								System.out.println("Card Successfully Charged Rs"+ FLT[i].getFlightFareVIP());
							}
							
							
							
							Cust.setFlightID(FLT[i].getFlightName());
							try {
								FLT[i].VIPbooking(Cust.getPassID(),seatnum);
							} catch (VIPBookingError e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Cust.setSeatNo(seatnum);
							System.out.println("Seat Successfully Booked...");
							Cust.PrintTicket(FLT[i]);
						}
						
						//if(FLT[i].PassengerID_stauts[][])
						
					
					
					}
				}
				for(int i=0;i<100;i++) {
					if(CST[i]==null) {
						CST[i]=Cust;
						break;
					}
				}
			}
			
			
			
				option=3;
		}
		if(option==2) {
			System.out.println("Kindly enter your passenger ID:");
			Scanner PID = new Scanner(System.in);  // Reading from System.in
			int  PASSID=PID.nextInt();
			String PlaneID = null;
			boolean foundID=false;
			
			for(int i=0;CST[i]!=null;i++) {
				if(CST[i].getPassID()==PASSID) {
					CST[i].PrintINFO();
					PlaneID=CST[i].getFlightID();
					foundID=true;
				}
			}
			
			if(foundID==false) {
				  throw new PASSID("Passenger ID does not exist");
			}
			
			
			System.out.println("1.Cancel your booking,2.Print Ticket");
			Scanner opt2 = new Scanner(System.in);  // Reading from System.in
			int  option2=opt2.nextInt();
			
			if(option2==1) {
				for(int i=0;FLT[i]!=null;i++) {
					if(FLT[i].getFlightName().equals(PlaneID)) {
						
						
						
						
						FLT[i].RemoveBooking(PASSID);
						
						
						System.out.println("Your amount will be returned to your account in 7 working days."+"\r\n"+"Thank you for your time...");
					
					}
				}
				
				option=3;
			
				
				
			}
			if(option==2) {
				
				for(int i=0;CST[i]!=null;i++) {
					if(CST[i].getPassID()==PASSID) {
						
						for(int j=0;FLT[j]!=null;j++) {
							if(CST[i].getFlightID().equals(FLT[j].getFlightName())) {
								CST[i].PrintTicket(FLT[j]);
								
							}
						}
						
						
					}
				}
				option=3;
			}
			
			
			
		}
		
		if(option==3) {
			
			
			 try {
			      FileWriter myWriter = new FileWriter("Customers.txt");
			      for(int i=0;CST[i]!=null;i++) {
			    	  myWriter.write(CST[i].getName()+","+CST[i].getGender()+","+CST[i].getAge()+","+CST[i].getAddress()+","+CST[i].getPassportNum()+","+CST[i].getOrigin()+","+CST[i].getDestination()+","+CST[i].getFlightID()+","+CST[i].getPassID()+","+CST[i].getSeatNo());
			    	  myWriter.write("\r\n");
			      }
			      
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			 
			 
			 try {
			      FileWriter myWriter = new FileWriter("Flights.txt");
			      for(int i=0;FLT[i]!=null;i++) {
			    	  myWriter.write(FLT[i].getFlightName()+","+FLT[i].getOrigin()+","+FLT[i].getDestination()+","+FLT[i].getFlightDate()+","+FLT[i].getFlightType()+","+FLT[i].getFlightFareEco()+","+FLT[i].getFlightFareVIP()+","+FLT[i].getTime());
			    	  myWriter.write("\r\n");
			      }
			      
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			 
			 
			 
			 
			 
			
			
			
			System.out.println("\r\n"+"\r\n"+"Exiting FRS...");
			 System.exit(0);
		}
	}

}
