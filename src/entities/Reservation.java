package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException( "Check-out date must be after check-in date");		
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public void setChekIn(LocalDate chekIn) {
		this.checkIn = chekIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		
		return ChronoUnit.DAYS.between(checkIn, checkOut);
		
	}
	
	public void updateDates( LocalDate checkIn, LocalDate checkOut) {
		
		LocalDate now = LocalDate.now();
		if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException( "Reservation dates for update must be future dates");
		}
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException( "Check-out date must be after check-in date");
			
		}
			this.checkIn = checkIn;
			this.checkOut = checkOut;	
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", checkin: "
				+ fmt.format(checkIn)
				+ ", checkout: "
				+ fmt.format(checkOut)
				+ ", "
				+ duration()
				+ " nights.";
		
	}
	
	

}
