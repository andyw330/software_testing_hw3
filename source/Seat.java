package system;

public class Seat implements Comparable<Seat> {

	private boolean isAvailable = false;
	
	private boolean isRegistered = false;//
	
	private FoodOrder foodType;//
	
	private int codeNumber = 0;//
	
	public final SeatType seatType;
	
	public final int seatNumber;
	
	public final String seatName;
	
	public final int seatPrice;
	
	public boolean isAvailable(){
		return isAvailable;
	}
	
	public boolean isRegistered(){
		return isRegistered;
	}
	
	public boolean isBookable(){
		if(!isRegistered&&isAvailable){
			return true;
		}else{
			return false;
		}
	}
	
	public Seat(){
		seatType=TYPE.EC;
		seatNumber=0;
		isAvailable=false;
		seatPrice=0;
		foodType=FOOD.NONE;
		seatName="Unavailable";
	}
	
	public Seat(SeatType tempType, int tempNumber, char tempChar){
		seatType=tempType;
		seatNumber=tempNumber;
		isAvailable=true;
		seatPrice=tempType.price;
		foodType=FOOD.NONE;
		seatName=tempChar + String.valueOf(tempNumber);
	}
	
	public void notAvailable(){
		this.isAvailable=false;
	}
	
	public void register(int temp){
		this.isRegistered=true;
		this.codeNumber=temp;
	}
	
	public void unregister(){
		this.isRegistered=false;
		this.codeNumber=0;
		foodType=FOOD.NONE;
	}
	
	public int getCode(){
		return codeNumber;
	}
	
	public void orderFood(FoodOrder temp){
		foodType=temp;
	}
	
	public int getPrice(){
		return seatPrice + foodType.price;
	}
	
	public int getSeatPrice(){
		return seatPrice;
	}
	
	public int compareTo(Seat tempSeat) {
		String intValue1=this.seatName.replaceAll("[A-Z]", "");
		String intValue2=tempSeat.seatName.replaceAll("[A-Z]", "");
		Integer temp1, temp2;
		temp1=Integer.parseInt(intValue1);
		temp2=Integer.parseInt(intValue2);
		if(!temp1.equals(temp2)){
			return temp1.compareTo(temp2);
		}else{
			return this.seatName.compareTo(tempSeat.seatName);
		}
	}
	
	public void showInfo(){
		System.out.println("Info " + seatName + " " + foodType.food + " " + getPrice());
	}
	
	public String foodType(){
		return foodType.food;
	}
}
