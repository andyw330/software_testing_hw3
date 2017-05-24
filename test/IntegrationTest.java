package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stubs.FOOD;
import stubs.RandomCode;
import stubs.Seat;
import stubs.TYPE;
import stubs.SeatType;
import stubs.Plane;

public class IntegrationTest {

	Plane p;

	public void register(SeatType type, int num){
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(type, num);
		p.numberCode++;
	}

	@Before
	public void setUp() throws Exception {
		p = new Plane();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void test1() {
		int org = p.seatsLeft(TYPE.EC);
		assertEquals(220, org);
		
		register(TYPE.EC, 1);
		assertEquals(true, p.codeList[0].seats[0].isRegistered());
		assertEquals(org-1, p.seatsLeft(TYPE.EC));

		register(TYPE.EC, 3);
		assertEquals(org-4, p.seatsLeft(TYPE.EC));

		p.unregisterSeat(p.codeList[0].seats[0]);
		assertEquals(org-3, p.seatsLeft(TYPE.EC));

		assertEquals(false, p.registerAble(TYPE.EC, org));

		org = p.seatsLeft(TYPE.SBC);
		assertEquals(32, org);

		register(TYPE.SBC, 1);
		assertEquals(org-1, p.seatsLeft(TYPE.SBC));

		p.codeList[2].orderFood(FOOD.VEGETABLE);
		assertEquals("Vegetable", p.codeList[2].seats[0].foodType());
		assertEquals(50500, p.codeList[2].seats[0].getPrice());
		assertEquals(50000, p.codeList[2].seats[0].getSeatPrice());

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		p.codeList[2].showInfo();
		assertEquals("Info 00000003 A6 50500\n", outContent.toString());
	}
}