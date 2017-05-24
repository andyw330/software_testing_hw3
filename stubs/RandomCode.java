package stubs;

import java.util.Arrays;

public class RandomCode {

	private int code;

	private int numberSeats = 0;

	public Seat[] seats = new Seat[400];

	public boolean usable = false;

	public RandomCode(int num) {
		code = num;
		usable = true;
	}

	public void addSeat(Seat temp) {
		seats[this.numberSeats] = temp;
		this.numberSeats++;
	}

	public void removeSeat(Seat temp) {
		// if (numberSeats == 1) {
		// 	numberSeats--;
		// 	usable = false;
		// 	return;
		// }
		// for (int i = 0; i < numberSeats; i++) {
		// 	if (temp.equals(seats[i])) {
		// 		seats[i] = seats[numberSeats - 1];
		// 		numberSeats--;
		// 		return;
		// 	}
		// }
	}

	public void unregisterCode() {
		// for (int i = 0; i < numberSeats; i++) {
		// 	seats[i].unregister();
		// }
		// numberSeats = 0;
		// usable = false;
	}

	public int getCode() {
		// return code;
		return 1;
	}

	public void showCode() {
		// System.out.print(String.format("%08d", code));
	}

	public int numberSeats() {
		// return numberSeats;
		return 282;
	}

	public void sortSeats() {
		// Arrays.sort(seats, 0, numberSeats);
	}

	public void orderFood(FoodOrder temp) {
		// for (int i = 0; i < numberSeats; i++) {
		// 	seats[i].orderFood(temp);
		// }
	}

	public void showInfo() {
		// int total = 0;
		// System.out.print("Info ");
		// showCode();
		// sortSeats();
		// for (int i = 0; i < numberSeats; i++) {
		// 	System.out.print(" " + seats[i].seatName);
		// 	total = total + seats[i].getPrice();
		// }
		// System.out.println(" " + total);
		System.out.println("Info 00000003 A6 50500\r");
	}
}
