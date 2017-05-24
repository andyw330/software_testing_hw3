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

public class SeatBoundaryValueTesting {

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
	public void orderFoodTest_BoundaryValueTesting() {
		s1.orderFood(FOOD.BEEF);
		assertEquals("Beef", s1.foodType());
	}

	@Test
	public void getSeatPriceTest_BoundaryValueTesting() {
		s1 = new Seat(TYPE.EC, 1, 'A');
		assertEquals(5000, s1.getSeatPrice());
	}

	@Test
	public void getPriceTest_BoundaryValueTesting() {
		s1 = new Seat(TYPE.EC, 1, 'A');
		s1.orderFood(FOOD.BEEF);
		assertEquals(7000, s1.getPrice());
	}

	@Test
	public void registerTest_BoundaryValueTesting() {
		s1.register(1);
		assertEquals(1, s1.getCode());
		assertEquals(true, s1.isRegistered());
	}

	@Test
	public void isAvailableTest_BoundaryValueTesting() {
		assertEquals(true, s1.isAvailable());
	}

	@Test
	public void isBookableTest_BoundaryValueTesting() {
		assertEquals(true, s1.isBookable());
	}

	@Test
	public void showInfoTest_BoundaryValueTesting() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		s1.showInfo();

		assertEquals("Info A1 None 5000\n", outContent.toString());
	}

	@Test
	public void notAvailableTest_BoundaryValueTesting() {
		s1.notAvailable();
		assertEquals(false, s1.isAvailable());
	}

	@Test
	public void unregisterTest_BoundaryValueTesting() {
		s1.unregister();
		assertEquals(false, s1.isRegistered());
	}
}