package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;

import source.FOOD;
import source.Seat;
import source.TYPE;

public class SeatCodeCoverageMCDC {

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
	public void orderFoodTest_CodeCoverageMCDC() {
		s1.orderFood(FOOD.BEEF);
		assertEquals("Beef", s1.foodType());
	}

	@Test
	public void getSeatPriceTest_CodeCoverageMCDC() {
		s1 = new Seat(TYPE.EC, 1, 'A');
		assertEquals(5000, s1.getSeatPrice());
	}

	@Test
	public void registerTest_CodeCoverageMCDC() {
		s1.register(1);
		assertEquals(1, s1.getCode());
		assertEquals(true, s1.isRegistered());
	}

	@Test
	public void isAvailableTest_CodeCoverageMCDC() {
		assertEquals(true, s1.isAvailable());
	}

	@Test
	public void isBookableTest_CodeCoverageMCDC() {
		assertEquals(true, s1.isBookable());

		s1.register(1);
		assertEquals(1, s1.getCode());
		assertEquals(false, s1.isBookable());
	}

	@Test
	public void showInfoTest_CodeCoverageMCDC() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		s1.showInfo();

		assertEquals("Info A1 None 5000\n", outContent.toString());
	}

	@Test
	public void notAvailableTest_CodeCoverageMCDC() {
		s1.notAvailable();
		assertEquals(false, s1.isAvailable());
	}

	@Test
	public void unregisterTest_CodeCoverageMCDC() {
		s1.unregister();
		assertEquals(false, s1.isRegistered());
	}
}