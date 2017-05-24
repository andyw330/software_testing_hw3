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

public class RandomCodeDecisionTableBasedTesting {

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

	@Test
	public void addSeatTest_DecisionTableBasedTesting() {
		for (int i = 0; i < 192; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(192, r.numberSeats());
	}

	@Test
	public void removeSeatTest_DecisionTableBasedTesting() {
		for (int i = 0; i < 384; ++i) {
			r.addSeat(seats[i]);
		}
		for (int i = 0; i < 192; ++i) {
			r.removeSeat(seats[i]);
		}
		assertEquals(192, r.numberSeats());
	}

	@Test
	public void unregisterCodeTest_DecisionTableBasedTesting() {
		r.unregisterCode();
		assertEquals(0, r.numberSeats());
		assertEquals(false, r.usable);
	}

	@Test
	public void getCodeTest_DecisionTableBasedTesting() {
		r = new RandomCode(Integer.MAX_VALUE / 2);
		assertEquals(Integer.MAX_VALUE / 2, r.getCode());
	}

	// #digits < 8 => left padding to length 8 with zero
	// #digits >= 8 => no left padding
	@Test
	public void showCodeTest_DecisionTableBasedTesting() {
		setUpStreams();
		r = new RandomCode(1234);
		r.showCode();
		assertEquals("00001234", outContent.toString());
		setUpStreams();
		r = new RandomCode(123456789);
		r.showCode();
		assertEquals("123456789", outContent.toString());
	}

	@Test
	public void orderFoodTest_DecisionTableBasedTesting() {
		r = new RandomCode(1);
		for (int i = 0; i < 384; ++i) {
			r.addSeat(seats[i]);
		}
		r.orderFood(FOOD.BEEF);
		assertEquals("Beef", r.seats[191].foodType());
		r.orderFood(FOOD.PORK);
		assertEquals("Pork", r.seats[191].foodType());
		r.orderFood(FOOD.VEGETABLE);
		assertEquals("Vegetable", r.seats[191].foodType());
		r.orderFood(FOOD.NONE);
		assertEquals("None", r.seats[191].foodType());
	}

	@Test
	public void showInfoTest_DecisionTableBasedTesting() {
		setUpStreams();
		r = new RandomCode(1);
		r.addSeat(new Seat(TYPE.EC, 1, 'A'));
		r.addSeat(new Seat(TYPE.SBC, 1, 'B'));
		r.showInfo();
		assertEquals("Info 00000001 A1 B1 55000\n", outContent.toString());
	}

	@Test
	public void sortSeatsTest_DecisionTableBasedTesting() {
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
