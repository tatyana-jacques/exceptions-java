package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
				System.out.print("Room number: ");
				int roomNumber = sc.nextInt();
				System.out.print("Check-in date(dd/MM/yyyy): ");
				LocalDate checkIn = LocalDate.parse(sc.next(),fmt);
				System.out.print("Check-out date(dd/MM/yyyy): ");
				LocalDate checkOut = LocalDate.parse(sc.next(),fmt);
				
				
				Reservation reservation = new Reservation(roomNumber, checkIn,checkOut);
				System.out.println(reservation);
				
				System.out.println();
				System.out.println("Enter data to update the reservation:");
				System.out.print("Check-in date(dd/MM/yyyy): ");
				checkIn = LocalDate.parse(sc.next(),fmt);
				System.out.print("Check-out date(dd/MM/yyyy): ");
				checkOut = LocalDate.parse(sc.next(),fmt);
				
				
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
				
			}	
		catch (InputMismatchException e) {
				System.out.println("Error: invalid input.");
			}
		
		catch(DateTimeParseException e) {
					System.out.println("Invalid date format.");
				
			}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
			
		}
		
	
		sc.close();
	}
	
	

}
