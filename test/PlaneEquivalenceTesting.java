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

public class PlaneEquivalenceTesting {

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
	public void bootTest_EquivalenceTesting() {
		assertEquals(true, p.seatList[0].equals(p.A));
		assertEquals(true, p.foodList[0].equals(FOOD.NONE));
		assertEquals(true, p.typeList[0].equals(TYPE.EC));
	}

	@Test
	public void insertSeatsTest_EquivalenceTesting() {
		p.insertSeats();
		assertEquals("A1", p.A[1].seatName);
		assertEquals("A6", p.A[6].seatName);
		assertEquals("A27", p.A[27].seatName);
		assertEquals("A45", p.A[45].seatName);
	}

	@Test
	public void removeRowATest_EquivalenceTesting() {
		p.removeRowA(1);
		assertEquals(false, p.A[1].isAvailable());
	}

	@Test
	public void removeRowBTest_EquivalenceTesting() {
		p.removeRowB(45);
		assertEquals(false, p.B[45].isAvailable());
	}

	@Test
	public void removeRowCTest_EquivalenceTesting() {
		p.removeRowC(1);
		assertEquals(false, p.C[1].isAvailable());
	}

	@Test
	public void removeRowDTest_EquivalenceTesting() {
		p.removeRowD(27);
		assertEquals(false, p.D[27].isAvailable());
	}

	@Test
	public void removeRowETest_EquivalenceTesting() {
		p.removeRowE(27);
		assertEquals(false, p.E[27].isAvailable());
	}

	@Test
	public void removeRowFTest_EquivalenceTesting() {
		p.removeRowF(27);
		assertEquals(false, p.F[27].isAvailable());
	}

	@Test
	public void removeRowGTest_EquivalenceTesting() {
		p.removeRowG(27);
		assertEquals(false, p.G[27].isAvailable());
	}

	@Test
	public void removeRowHTest_EquivalenceTesting() {
		p.removeRowH(1);
		assertEquals(false, p.H[1].isAvailable());
	}

	@Test
	public void removeRowJTest_EquivalenceTesting() {
		p.removeRowJ(45);
		assertEquals(false, p.J[45].isAvailable());
	}

	@Test
	public void removeRowKTest_EquivalenceTesting() {
		p.removeRowK(1);
		assertEquals(false, p.K[1].isAvailable());
	}

	@Test
	public void seatsLeftTest_EquivalenceTesting() {
		assertEquals(384, p.seatsLeft());
	}

	@Test
	public void seatsLeftTest2_EquivalenceTesting() {
		assertEquals(220, p.seatsLeft(TYPE.EC));
		assertEquals(120, p.seatsLeft(TYPE.EDC));
		assertEquals(32, p.seatsLeft(TYPE.SBC));
		assertEquals(12, p.seatsLeft(TYPE.SFC));
	}

	@Test
	public void registerableTest_EquivalenceTesting() {
		assertEquals(true, p.registerAble(TYPE.SFC, 1));
		assertEquals(true, p.registerAble(TYPE.SBC, 2));
		assertEquals(true, p.registerAble(TYPE.EDC, 5));
		assertEquals(true, p.registerAble(TYPE.EC, 31));
	}

	@Test
	public void registerTypeTest_EquivalenceTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SFC, 12);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SBC, 3);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EDC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

	}

	@Test
	public void unregisterSeatTest_EquivalenceTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EC, 1);
		Seat s = p.codeList[p.numberCode].seats[0];
		p.unregisterSeat(s);
		assertEquals(false, p.codeList[0].usable);
	}
}