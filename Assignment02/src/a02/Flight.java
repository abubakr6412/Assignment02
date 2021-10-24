package a02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;





class EcoBookingError  extends Exception  
{  
    public EcoBookingError (String str)  
    {  
       
        super(str);  
    }  
} 
class VIPBookingError  extends Exception  
{  
    public VIPBookingError (String str)  
    {  
       
        super(str);  
    }  
} 
class DateNotFound  extends Exception  
{  
    public DateNotFound (String str)  
    {  
       
        super(str);  
    }  
} 

public class Flight {

	private String FlightName,Origin,Destination,FlightDate,FlightType;
	
	public int[] PassengersID_Status = new int[50];//0=No booking,1=cancel,2=reserved
	public int[] SeatStatus=new int[50];//50, 30 seats eco,20 vip
	
	
	private int FlightFareEco;
	private int FlightFareVIP;
	String time;
	

	
	public Flight(String FName,String og,String dst,String Fdate,String Ftype,int ecoP,int vipP,String t) {
		FlightName=FName;
		Origin=og;
		Destination=dst;
		FlightDate=Fdate;
		FlightType=Ftype;
		FlightFareEco=ecoP;
		FlightFareVIP=vipP;
		time=t;
		
	}
	public void Economybooking(int PassID,int seatno) throws EcoBookingError {
		
		
			if(PassengersID_Status[seatno]==0) {
				PassengersID_Status[seatno]=PassID;
				SeatStatus[seatno]=2;
				return;
			}
			else {
				  throw new EcoBookingError("Seat not available");
			}
		}
		
		
	
	
	public void EconomyPrint() {
		for(int i=0;i<30;i++) {
			System.out.println(PassengersID_Status[i]+" "+SeatStatus[i]+"\r\n");
		}
	}
	
public void VIPbooking(int PassID,int seatno) throws VIPBookingError {
		
		
			if(PassengersID_Status[seatno]==0) {
				PassengersID_Status[seatno]=PassID;
				SeatStatus[seatno]=2;
				return;
			}
			{
				 throw new VIPBookingError("Seat not available");
			}
		
		
		
	}

public void RemoveBooking(int PassID) {
	for(int i=0;i<50;i++) {
		if(PassengersID_Status[i]==PassID) {
			PassengersID_Status[i]=0;
			SeatStatus[i]=1;
		}
	}
}
	
	public void VIPPrint() {
		for(int i=30;i<49;i++) {
			System.out.println(PassengersID_Status[i]+" "+SeatStatus[i]+"\r\n");
		}
	}
	
	public Flight CheapestDate(Flight[] FLT,String date,String OG,String DST) throws DateNotFound {
		int[] myIntArray = new int[10];
		int counter=0;
		for(int i=0;FLT[i]!=null;i++) {
			if(FLT[i].getOrigin().equals(OG) && FLT[i].getDestination().equals(DST) && FLT[i].getFlightDate().equals(date)) {
			myIntArray[counter]=i;
			counter++;
			}
		}
		// Change < to > if you want to find the smallest element
//	       if(arr[0] < arr[i])
//	           arr[0] = arr[i];
		int price = 0;
		price=FLT[myIntArray[0]].getFlightFareEco();
		for(int i=0;i<counter;i++) {
			
			
			if(price>FLT[myIntArray[i]].getFlightFareEco()) {
				price=FLT[myIntArray[i]].getFlightFareEco();
			}
		}
		
		
		for(int i=0;FLT[i]!=null;i++) {
			if(FLT[i].getFlightFareEco()==price && FLT[i].getOrigin().equals(OG) && FLT[i].getDestination().equals(DST) && FLT[i].getFlightDate().equals(date)) {
			return FLT[i];
			}
		}
		
		throw new DateNotFound("Not available on requested date.");
		
		
	}
	
	public void indirectFlights(Flight[] Flights,String Date,String Origin,String Destination) {
		int[] myIntArray = new int[10];
		int[] myIntArray2 = new int[10];
		int counter=0;
		int counter2=0;
		
		for(int i=0;Flights[i]!=null;i++) {
			if(Flights[i].getFlightDate().equals(Date)) {
				myIntArray[counter]=i;
				counter++;
			}
		}
		
		for(int i=0;i<counter;i++) {
			if(Flights[myIntArray[i]].Origin.equals(Origin)) {
				myIntArray2[counter2]=i;
				counter2++;
			}
		}
		
		
		for(int i=0;i<counter;i++) {
			if(Flights[myIntArray2[i]].Destination.equals(Origin)) {
				myIntArray2[counter2]=i;
				counter2++;
			}
		}
		
		
		
		
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
	public String getFlightDate() {
		return FlightDate;
	}
	public void setFlightDate(String flightDate) {
		FlightDate = flightDate;
	}
	public String getFlightType() {
		return FlightType;
	}
	public void setFlightType(String flightType) {
		FlightType = flightType;
	}

	public String getFlightName() {
		return FlightName;
	}
	public void setFlightName(String flightName) {
		FlightName = flightName;
	}
	public int getFlightFareEco() {
		return FlightFareEco;
	}
	public void setFlightFareEco(int flightFareEco) {
		FlightFareEco = flightFareEco;
	}
	public int getFlightFareVIP() {
		return FlightFareVIP;
	}
	public void setFlightFareVIP(int flightFareVIP) {
		FlightFareVIP = flightFareVIP;
	}
	public String getTime() {
		return time;
	}
	
	public void PRINTINFO() {
		System.out.println("FlightName: "+ FlightName +"\r\n"+"Origin: "+Origin+"\r\n"+"Destination: "+Destination+"\r\n"+"Flight Date: "+FlightDate+"\r\n"+"Plane type: "+ FlightType+"\r\n"+"Economy Class Cost: "+FlightFareEco+"\r\n"+"VIP Class Cost: "+FlightFareVIP+"\r\n"+"Departure time: "+time);
	}


	
	
	
}
