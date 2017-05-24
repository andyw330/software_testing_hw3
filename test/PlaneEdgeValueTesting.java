package test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

import source.Plane;
import source.TYPE;
import source.FOOD;
import source.RandomCode;
import source.Seat;

public class PlaneEdgeValueTesting {

	Plane p;

	@Before
	public void setUp() throws Exception {
		p = new Plane();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void bootTest_EdgeValueTesting() {
		assertEquals(true, p.seatList[0].equals(p.A));
		assertEquals(true, p.seatList[1].equals(p.B));
		assertEquals(true, p.seatList[8].equals(p.J));
		assertEquals(true, p.seatList[9].equals(p.K));

		assertEquals(true, p.foodList[0].equals(FOOD.NONE));
		assertEquals(true, p.foodList[1].equals(FOOD.VEGETABLE));
		assertEquals(true, p.foodList[2].equals(FOOD.PORK));
		assertEquals(true, p.foodList[3].equals(FOOD.BEEF));

		assertEquals(true, p.typeList[0].equals(TYPE.EC));
		assertEquals(true, p.typeList[1].equals(TYPE.EDC));
		assertEquals(true, p.typeList[2].equals(TYPE.SBC));
		assertEquals(true, p.typeList[3].equals(TYPE.SFC));
	}

	@Test
	public void insertSeatsTest_EdgeValueTesting() {
		p.insertSeats();
		// SFC
		assertEquals("A1", p.A[1].seatName);
		assertEquals("A3", p.A[3].seatName);

		// SBC
		assertEquals("A6", p.A[6].seatName);
		assertEquals("A13", p.A[13].seatName);

		// EDC
		assertEquals("A27", p.A[27].seatName);
		assertEquals("A41", p.A[41].seatName);

		// EC
		assertEquals("A45", p.A[45].seatName);
		assertEquals("A70", p.A[70].seatName);
	}

	@Test
	public void removeRowATest_EdgeValueTesting() {
		p.removeRowA(1);
		assertEquals(false, p.A[1].isAvailable());
		p.removeRowA(2);
		assertEquals(false, p.A[2].isAvailable());
		p.removeRowA(69);
		assertEquals(false, p.A[69].isAvailable());
		p.removeRowA(70);
		assertEquals(false, p.A[70].isAvailable());
	}

	@Test
	public void removeRowBTest_EdgeValueTesting() {
		p.removeRowB(45);
		assertEquals(false, p.B[45].isAvailable());
		p.removeRowB(46);
		assertEquals(false, p.B[46].isAvailable());
		p.removeRowB(69);
		assertEquals(false, p.B[69].isAvailable());
		p.removeRowB(70);
		assertEquals(false, p.B[70].isAvailable());
	}

	@Test
	public void removeRowCTest_EdgeValueTesting() {
		p.removeRowC(1);
		assertEquals(false, p.C[1].isAvailable());
		p.removeRowC(2);
		assertEquals(false, p.C[2].isAvailable());
		p.removeRowC(69);
		assertEquals(false, p.C[69].isAvailable());
		p.removeRowC(70);
		assertEquals(false, p.C[70].isAvailable());
	}

	@Test
	public void removeRowDTest_EdgeValueTesting() {
		p.removeRowD(27);
		assertEquals(false, p.D[27].isAvailable());
		p.removeRowD(28);
		assertEquals(false, p.D[28].isAvailable());
		p.removeRowD(69);
		assertEquals(false, p.D[69].isAvailable());
		p.removeRowD(70);
		assertEquals(false, p.D[70].isAvailable());
	}

	@Test
	public void removeRowETest_EdgeValueTesting() {
		p.removeRowE(27);
		assertEquals(false, p.E[27].isAvailable());
		p.removeRowE(28);
		assertEquals(false, p.E[28].isAvailable());
		p.removeRowE(69);
		assertEquals(false, p.E[69].isAvailable());
		p.removeRowE(70);
		assertEquals(false, p.E[70].isAvailable());
	}

	@Test
	public void removeRowFTest_EdgeValueTesting() {
		p.removeRowF(27);
		assertEquals(false, p.F[27].isAvailable());
		p.removeRowF(28);
		assertEquals(false, p.F[28].isAvailable());
		p.removeRowF(69);
		assertEquals(false, p.F[69].isAvailable());
		p.removeRowF(70);
		assertEquals(false, p.F[70].isAvailable());
	}

	@Test
	public void removeRowGTest_EdgeValueTesting() {
		p.removeRowG(27);
		assertEquals(false, p.G[27].isAvailable());
		p.removeRowG(28);
		assertEquals(false, p.G[28].isAvailable());
		p.removeRowG(69);
		assertEquals(false, p.G[69].isAvailable());
		p.removeRowG(70);
		assertEquals(false, p.G[70].isAvailable());
	}

	@Test
	public void removeRowHTest_EdgeValueTesting() {
		p.removeRowH(1);
		assertEquals(false, p.H[1].isAvailable());
		p.removeRowH(2);
		assertEquals(false, p.H[2].isAvailable());
		p.removeRowH(69);
		assertEquals(false, p.H[69].isAvailable());
		p.removeRowH(70);
		assertEquals(false, p.H[70].isAvailable());
	}

	@Test
	public void removeRowJTest_EdgeValueTesting() {
		p.removeRowJ(45);
		assertEquals(false, p.J[45].isAvailable());
		p.removeRowJ(46);
		assertEquals(false, p.J[46].isAvailable());
		p.removeRowJ(69);
		assertEquals(false, p.J[69].isAvailable());
		p.removeRowJ(70);
		assertEquals(false, p.J[70].isAvailable());
	}

	@Test
	public void removeRowKTest_EdgeValueTesting() {
		p.removeRowK(1);
		assertEquals(false, p.K[1].isAvailable());
		p.removeRowK(2);
		assertEquals(false, p.K[2].isAvailable());
		p.removeRowK(69);
		assertEquals(false, p.K[69].isAvailable());
		p.removeRowK(70);
		assertEquals(false, p.K[70].isAvailable());
	}

	@Test
	public void seatsLeftTest_EdgeValueTesting() {
		assertEquals(384, p.seatsLeft());
	}

	@Test
	public void seatsLeftTest2_EdgeValueTesting() {
		assertEquals(220, p.seatsLeft(TYPE.EC));
		assertEquals(120, p.seatsLeft(TYPE.EDC));
		assertEquals(32, p.seatsLeft(TYPE.SBC));
		assertEquals(12, p.seatsLeft(TYPE.SFC));
	}

	@Test
	public void registerableTest_EdgeValueTesting() {
		assertEquals(true, p.registerAble(TYPE.SFC, 1));
		assertEquals(true, p.registerAble(TYPE.SFC, 2));
		assertEquals(true, p.registerAble(TYPE.SFC, 11));
		assertEquals(true, p.registerAble(TYPE.SFC, 12));

		assertEquals(true, p.registerAble(TYPE.SBC, 1));
		assertEquals(true, p.registerAble(TYPE.SBC, 2));
		assertEquals(true, p.registerAble(TYPE.SBC, 31));
		assertEquals(true, p.registerAble(TYPE.SBC, 32));

		assertEquals(true, p.registerAble(TYPE.EDC, 1));
		assertEquals(true, p.registerAble(TYPE.EDC, 2));
		assertEquals(true, p.registerAble(TYPE.EDC, 119));
		assertEquals(true, p.registerAble(TYPE.EDC, 120));

		assertEquals(true, p.registerAble(TYPE.EC, 1));
		assertEquals(true, p.registerAble(TYPE.EC, 2));
		assertEquals(true, p.registerAble(TYPE.EC, 219));
		assertEquals(true, p.registerAble(TYPE.EC, 220));
	}

	@Test
	public void registerTypeTest_EdgeValueTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EC, 219);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EDC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EDC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EDC, 119);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SBC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SBC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SBC, 31);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SFC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SFC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SFC, 11);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

	}

	@Test
	public void unregisterSeatTest_EdgeValueTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EC, 1);
		Seat s = p.codeList[p.numberCode].seats[0];
		p.unregisterSeat(s);
		assertEquals(false, p.codeList[0].usable);
	}
}