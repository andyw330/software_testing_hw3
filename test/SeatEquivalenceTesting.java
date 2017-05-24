package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;

import source.FOOD;
import source.Seat;
import source.TYPE;

public class SeatEquivalenceTesting {

	Seat s1;

	@Before
	public void setUp() throws Exception {
		s1 = new Seat(TYPE.EC, 1, 'A');
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
	}

	@Test
	public void orderFoodTest_EquivalenceTesting() {
		s1.orderFood(FOOD.BEEF);
		assertEquals("Beef", s1.foodType());
		s1.orderFood(FOOD.PORK);
		assertEquals("Pork", s1.foodType());
		s1.orderFood(FOOD.VEGETABLE);
		assertEquals("Vegetable", s1.foodType());
		s1.orderFood(FOOD.NONE);
		assertEquals("None", s1.foodType());
	}

	@Test
	public void getSeatPriceTest_EquivalenceTesting() {
		s1 = new Seat(TYPE.EC, 1, 'A');
		assertEquals(5000, s1.getSeatPrice());
		s1 = new Seat(TYPE.EDC, 27, 'A');
		assertEquals(20000, s1.getSeatPrice());
		s1 = new Seat(TYPE.SBC, 6, 'A');
		assertEquals(50000, s1.getSeatPrice());
		s1 = new Seat(TYPE.SFC, 1, 'A');
		assertEquals(100000, s1.getSeatPrice());
	}

	@Test
	public void getPriceTest_EquivalenceTesting() {
		s1 = new Seat(TYPE.EC, 1, 'A');
		s1.orderFood(FOOD.BEEF);
		assertEquals(7000, s1.getPrice());

		s1 = new Seat(TYPE.EDC, 27, 'A');
		s1.orderFood(FOOD.VEGETABLE);
		assertEquals(20500, s1.getPrice());

		s1 = new Seat(TYPE.SBC, 6, 'A');
		s1.orderFood(FOOD.NONE);
		assertEquals(50000, s1.getPrice());
		s1.orderFood(FOOD.VEGETABLE);

		s1 = new Seat(TYPE.SFC, 1, 'A');
		s1.orderFood(FOOD.NONE);
		assertEquals(100000, s1.getPrice());
		s1.orderFood(FOOD.VEGETABLE);
	}

	@Test
	public void registerTest_EquivalenceTesting() {
		s1.register(1);
		assertEquals(1, s1.getCode());
		assertEquals(true, s1.isRegistered());
	}

	@Test
	public void isAvailableTest_EquivalenceTesting() {
		assertEquals(true, s1.isAvailable());
		s1 = new Seat();
		assertEquals(false, s1.isAvailable());
	}

	@Test
	public void isBookableTest_EquivalenceTesting() {
		assertEquals(true, s1.isBookable());
		s1.register(1);
		assertEquals(false, s1.isBookable());
	}

	@Test
	public void showInfoTest_EquivalenceTesting() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		s1.showInfo();

		assertEquals("Info A1 None 5000\n", outContent.toString());
	}

	@Test
	public void notAvailableTest_EquivalenceTesting() {
		s1.notAvailable();
		assertEquals(false, s1.isAvailable());
	}

	@Test
	public void unregisterTest_EquivalenceTesting() {
		s1.unregister();
		assertEquals(false, s1.isRegistered());
	}

}