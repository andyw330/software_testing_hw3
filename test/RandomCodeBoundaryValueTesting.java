package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import source.FOOD;
import source.RandomCode;
import source.Seat;
import source.TYPE;

public class RandomCodeBoundaryValueTesting {

	RandomCode r;
	Seat[] seats;

	private ByteArrayOutputStream outContent;

	private void setUpStreams() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Before
	public void setUp() throws Exception {
		r = new RandomCode(1);
		seats = new Seat[384];
		for (int i = 0; i < 384; ++i) {
			seats[i] = new Seat(TYPE.EC, 1, 'A');
		}
	}

	@After
	public void tearDown() throws Exception {
		r = null;
		seats = null;
		System.setOut(null);
	}

	// #seats <= 384
	@Test
	public void addSeatTest_BoundaryValueTesting() {
		assertEquals(0, r.numberSeats());

		r.addSeat(seats[0]);
		assertEquals(1, r.numberSeats());

		for (int i = 1; i < 383; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(383, r.numberSeats());

		r.addSeat(seats[383]);
		assertEquals(384, r.numberSeats());
	}

	@Test
	public void removeSeatTest_BoundaryValueTesting() {
		for (int i = 0; i < 384; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(384, r.numberSeats());

		r.removeSeat(seats[0]);
		assertEquals(383, r.numberSeats());

		for (int i = 1; i < 383; ++i) {
			r.removeSeat(seats[i]);
		}
		assertEquals(1, r.numberSeats());

		r.removeSeat(seats[383]);
		assertEquals(0, r.numberSeats());
	}

	@Test
	public void unregisterCodeTest_BoundaryValueTesting() {
		r.unregisterCode();
		assertEquals(0, r.numberSeats());
		assertEquals(false, r.usable);
	}

	@Test
	public void getCodeTest_BoundaryValueTesting() {
		r = new RandomCode(1);
		assertEquals(1, r.getCode());
		r = new RandomCode(2);
		assertEquals(2, r.getCode());
		r = new RandomCode(Integer.MAX_VALUE / 2);
		assertEquals(Integer.MAX_VALUE / 2, r.getCode());
		r = new RandomCode(Integer.MAX_VALUE - 1);
		assertEquals(Integer.MAX_VALUE - 1, r.getCode());
		r = new RandomCode(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, r.getCode());
	}

	@Test
	public void showCodeTest_BoundaryValueTesting() {
		setUpStreams();
		r = new RandomCode(1);
		r.showCode();
		assertEquals("00000001", outContent.toString());
		setUpStreams();
		r = new RandomCode(2);
		r.showCode();
		assertEquals("00000002", outContent.toString());
		setUpStreams();
		r = new RandomCode(Integer.MAX_VALUE / 2);
		r.showCode();
		assertEquals(Integer.toString(Integer.MAX_VALUE / 2), outContent.toString());
		setUpStreams();
		r = new RandomCode(Integer.MAX_VALUE - 1);
		r.showCode();
		assertEquals(Integer.toString((Integer.MAX_VALUE - 1)), outContent.toString());
		setUpStreams();
		r = new RandomCode(Integer.MAX_VALUE);
		r.showCode();
		assertEquals(Integer.toString(Integer.MAX_VALUE), outContent.toString());
	}

	@Test
	public void orderFoodTest_BoundaryValueTesting() {
		r = new RandomCode(1);
		for (int i = 0; i < 384; ++i) {
			r.addSeat(seats[i]);
		}
		r.orderFood(FOOD.BEEF);
		assertEquals("Beef", r.seats[0].foodType());
		assertEquals("Beef", r.seats[1].foodType());
		assertEquals("Beef", r.seats[191].foodType());
		assertEquals("Beef", r.seats[382].foodType());
		assertEquals("Beef", r.seats[383].foodType());
		r.orderFood(FOOD.PORK);
		assertEquals("Pork", r.seats[0].foodType());
		assertEquals("Pork", r.seats[1].foodType());
		assertEquals("Pork", r.seats[191].foodType());
		assertEquals("Pork", r.seats[382].foodType());
		assertEquals("Pork", r.seats[383].foodType());
		r.orderFood(FOOD.VEGETABLE);
		assertEquals("Vegetable", r.seats[0].foodType());
		assertEquals("Vegetable", r.seats[1].foodType());
		assertEquals("Vegetable", r.seats[191].foodType());
		assertEquals("Vegetable", r.seats[382].foodType());
		assertEquals("Vegetable", r.seats[383].foodType());
		r.orderFood(FOOD.NONE);
		assertEquals("None", r.seats[0].foodType());
		assertEquals("None", r.seats[1].foodType());
		assertEquals("None", r.seats[191].foodType());
		assertEquals("None", r.seats[382].foodType());
		assertEquals("None", r.seats[383].foodType());
	}

	@Test
	public void showInfoTest_BoundaryValueTesting() {
		setUpStreams();
		r = new RandomCode(1);
		r.addSeat(new Seat(TYPE.EC, 1, 'A'));
		r.addSeat(new Seat(TYPE.SBC, 1, 'B'));
		r.showInfo();
		assertEquals("Info 00000001 A1 B1 55000\n", outContent.toString());
	}

	@Test
	public void sortSeatsTest_BoundaryValueTesting() {
		r = new RandomCode(1);
		seats[0] = new Seat(TYPE.EC, 1, 'B');
		seats[1] = new Seat(TYPE.SBC, 1, 'A');
		r.addSeat(seats[0]);
		r.addSeat(seats[1]);
		r.sortSeats();
		assertEquals(true, r.seats[0].equals(this.seats[1]));
		assertEquals(true, r.seats[1].equals(this.seats[0]));
	}

}
