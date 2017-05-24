package source;

public class SeatType {

	public final int price;

	public final String type;

	public final int seatStart, seatEnd;

	public SeatType(String tempType, int tempPrice, int start, int end) {
		type = tempType;
		price = tempPrice;
		seatStart = start;
		seatEnd = end;
	}

}
