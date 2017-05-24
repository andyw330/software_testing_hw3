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

public class PlaneDecisionTableBasedTesting {

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
	public void bootTest_DecisionTableBasedTesting() {
		assertEquals(true, p.seatList[1].equals(p.B));
		assertEquals(true, p.foodList[0].equals(FOOD.NONE));
		assertEquals(true, p.typeList[2].equals(TYPE.SBC));
	}

	@Test
	public void insertSeatsTest_DecisionTableBasedTesting() {
		p.insertSeats();
		// SFC
		assertEquals("A1", p.A[1].seatName);

		// SBC
		assertEquals("A6", p.A[6].seatName);

		// EDC
		assertEquals("A27", p.A[27].seatName);

		// EC
		assertEquals("A45", p.A[45].seatName);
	}

	@Test
	public void removeRowATest_DecisionTableBasedTesting() {
		p.removeRowA(1);
		assertEquals(false, p.A[1].isAvailable());
	}

	@Test
	public void removeRowBTest_DecisionTableBasedTesting() {
		p.removeRowB(45);
		assertEquals(false, p.B[45].isAvailable());
	}

	@Test
	public void removeRowCTest_DecisionTableBasedTesting() {
		p.removeRowC(1);
		assertEquals(false, p.C[1].isAvailable());
	}

	@Test
	public void removeRowDTest_DecisionTableBasedTesting() {
		p.removeRowD(27);
		assertEquals(false, p.D[27].isAvailable());
	}

	@Test
	public void removeRowETest_DecisionTableBasedTesting() {
		p.removeRowE(27);
		assertEquals(false, p.E[27].isAvailable());
	}

	@Test
	public void removeRowFTest_DecisionTableBasedTesting() {
		p.removeRowF(27);
		assertEquals(false, p.F[27].isAvailable());
	}

	@Test
	public void removeRowGTest_DecisionTableBasedTesting() {
		p.removeRowG(27);
		assertEquals(false, p.G[27].isAvailable());
	}

	@Test
	public void removeRowHTest_DecisionTableBasedTesting() {
		p.removeRowH(1);
		assertEquals(false, p.H[1].isAvailable());
	}

	@Test
	public void removeRowJTest_DecisionTableBasedTesting() {
		p.removeRowJ(45);
		assertEquals(false, p.J[45].isAvailable());
	}

	@Test
	public void removeRowKTest_DecisionTableBasedTesting() {
		p.removeRowK(1);
		assertEquals(false, p.K[1].isAvailable());
	}

	@Test
	public void seatsLeftTest_DecisionTableBasedTesting() {
		assertEquals(384, p.seatsLeft());
	}

	@Test
	public void seatsLeftTest2_DecisionTableBasedTesting() {
		assertEquals(220, p.seatsLeft(TYPE.EC));
		assertEquals(120, p.seatsLeft(TYPE.EDC));
		assertEquals(32, p.seatsLeft(TYPE.SBC));
		assertEquals(12, p.seatsLeft(TYPE.SFC));
	}

	@Test
	public void registerableTest_DecisionTableBasedTesting() {
		assertEquals(true, p.registerAble(TYPE.SFC, 1));
		assertEquals(true, p.registerAble(TYPE.SBC, 2));
		assertEquals(true, p.registerAble(TYPE.EDC, 5));
		assertEquals(true, p.registerAble(TYPE.EC, 31));
	}

	@Test
	public void registerTypeTest_DecisionTableBasedTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.SFC, 11);
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
	public void unregisterSeatTest_DecisionTableBasedTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
		p.registerType(TYPE.EC, 1);
		Seat s = p.codeList[p.numberCode].seats[0];
		p.unregisterSeat(s);
		assertEquals(false, p.codeList[0].usable);
	}
}