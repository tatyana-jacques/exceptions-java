package application;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date(dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(),fmt);
		System.out.print("Check-out date(dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(),fmt);
		
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
			
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn,checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date(dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(),fmt);
			System.out.print("Check-out date(dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(),fmt);
			
			
			String error = reservation.updateDates(checkIn, checkOut);
			if(error !=null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				
				System.out.println(reservation);
			}		
			
		}

		sc.close();
	}
	
	

}
