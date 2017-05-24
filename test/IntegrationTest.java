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

public class IntegrationTest {

	Plane p;

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
	public void test1() {
		int org;
		org = p.seatsLeft(TYPE.EC);  
		register(TYPE.EC, 1);
		assertEquals(true, p.codeList[0].seats[0].isRegistered());
		assertEquals(org-1, p.seatsLeft(TYPE.EC));
		
		register(TYPE.EC, 3);
		assertEquals(org-4, p.seatsLeft(TYPE.EC));
		
		p.unregisterSeat(p.codeList[0].seats[0]);
		assertEquals(org-3, p.seatsLeft(TYPE.EC));
		
		assertEquals(false, p.registerAble(TYPE.EC, org));
		
		org = p.seatsLeft(TYPE.SBC);
		register(TYPE.SBC, 1);
		assertEquals(org-1, p.seatsLeft(TYPE.SBC));
		
		p.codeList[2].orderFood(FOOD.VEGETABLE);
		assertEquals("Vegetable", p.codeList[2].seats[0].foodType());
		
		assertEquals(50500, p.codeList[2].seats[0].getPrice());
		
		assertEquals(50000, p.codeList[2].seats[0].getSeatPrice());
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		p.codeList[2].showInfo();
		assertEquals("Info 00000003 A6 50500\r\n", outContent.toString());
	}

	@Test
	public void test2() {
		
		int org;
		org = p.seatsLeft(TYPE.EDC);  
		register(TYPE.EDC, 3);
		assertEquals(true, p.codeList[0].seats[0].isRegistered());
		assertEquals(org-3, p.seatsLeft(TYPE.EDC));
		
		register(TYPE.EDC, 3);
		assertEquals(org-6, p.seatsLeft(TYPE.EDC));
		
		p.unregisterSeat(p.codeList[0].seats[0]);
		assertEquals(org-5, p.seatsLeft(TYPE.EDC));
		
		assertEquals(false, p.registerAble(TYPE.EDC, org));
		
		org = p.seatsLeft(TYPE.SFC);
		register(TYPE.SFC, 1);
		assertEquals(org-1, p.seatsLeft(TYPE.SFC));
		
		p.codeList[2].orderFood(FOOD.PORK);
		assertEquals("Pork", p.codeList[2].seats[0].foodType());
		
		assertEquals(101000, p.codeList[2].seats[0].getPrice());
		
		assertEquals(100000, p.codeList[2].seats[0].getSeatPrice());
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		p.codeList[2].showInfo();
		assertEquals("Info 00000003 A1 101000\r\n", outContent.toString());
	}
	
	public void register(SeatType type, int num){
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(type, num);
		p.numberCode++;
	}
}