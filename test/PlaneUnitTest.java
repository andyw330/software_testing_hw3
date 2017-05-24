package test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

import system.Plane;
import system.TYPE;
import system.FOOD;
import system.RandomCode;
import system.Seat;

public class PlaneUnitTest {
	
	Plane p;

	@Before
	public void setUp() throws Exception {
		p = new Plane();
		System.out.println("Hello!");
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void bootTest_BoundaryValueTesting() {
		//test boot(), which is called in constructor
		assertEquals(true, p.seatList[0].equals(p.A));
		assertEquals(true, p.seatList[1].equals(p.B));
		assertEquals(true, p.seatList[4].equals(p.E));
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
	public void bootTest_EquivalenceTesting() {
		assertEquals(true, p.seatList[0].equals(p.A));
		assertEquals(true, p.foodList[0].equals(FOOD.NONE));
		assertEquals(true, p.typeList[0].equals(TYPE.EC));
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
	public void bootTest_DecisionTableBasedTesting() {
		assertEquals(true, p.seatList[1].equals(p.B));
		assertEquals(true, p.foodList[0].equals(FOOD.NONE));
		assertEquals(true, p.typeList[2].equals(TYPE.SBC));
	}

	@Test
	public void insertSeatsTest_BoundaryValueTesting() {
		assertEquals("A11", p.A[1].seatName);
		assertEquals("A2", p.A[2].seatName);
		assertEquals("A8", p.A[8].seatName);
		assertEquals("A69", p.A[69].seatName);
		assertEquals("A70", p.A[70].seatName);

		assertEquals("B45", p.B[45].seatName);
		assertEquals("B46", p.B[46].seatName);
		assertEquals("B47", p.B[47].seatName);
		assertEquals("B69", p.B[69].seatName);
		assertEquals("B70", p.B[70].seatName);

		assertEquals("C1", p.C[1].seatName);
		assertEquals("C2", p.C[2].seatName);
		assertEquals("C8", p.C[8].seatName);
		assertEquals("C69", p.C[69].seatName);
		assertEquals("C70", p.C[70].seatName);

		assertEquals("D27", p.D[27].seatName);
		assertEquals("D28", p.D[28].seatName);
		assertEquals("D29", p.D[29].seatName);
		assertEquals("D69", p.D[69].seatName);
		assertEquals("D70", p.D[70].seatName);

		assertEquals("E27", p.E[27].seatName);
		assertEquals("E28", p.E[28].seatName);
		assertEquals("E29", p.E[29].seatName);
		assertEquals("E69", p.E[69].seatName);
		assertEquals("E70", p.E[70].seatName);

		assertEquals("F27", p.F[27].seatName);
		assertEquals("F28", p.F[28].seatName);
		assertEquals("F29", p.F[29].seatName);
		assertEquals("F69", p.F[69].seatName);
		assertEquals("F70", p.F[70].seatName);

		assertEquals("G27", p.G[27].seatName);
		assertEquals("G28", p.G[28].seatName);
		assertEquals("G29", p.G[29].seatName);
		assertEquals("G69", p.G[69].seatName);
		assertEquals("G70", p.G[70].seatName);

		assertEquals("H1", p.H[1].seatName);
		assertEquals("H2", p.H[2].seatName);
		assertEquals("H8", p.H[8].seatName);
		assertEquals("H69", p.H[69].seatName);
		assertEquals("H70", p.H[70].seatName);

		assertEquals("J45", p.J[45].seatName);
		assertEquals("J46", p.J[46].seatName);
		assertEquals("J60", p.J[60].seatName);
		assertEquals("J69", p.J[69].seatName);
		assertEquals("J70", p.J[70].seatName);

		assertEquals("K1", p.K[1].seatName);
		assertEquals("K2", p.K[2].seatName);
		assertEquals("K8", p.K[8].seatName);
		assertEquals("K69", p.K[69].seatName);
		assertEquals("K70", p.K[70].seatName);
	}

	@Test
	public void insertSeatsTest_EquivalenceTesting() {
		assertEquals("A1", p.A[1].seatName);
		assertEquals("A6", p.A[6].seatName);
		assertEquals("A27", p.A[27].seatName);
		assertEquals("A45", p.A[45].seatName);
	}
	
	@Test
	public void insertSeatsTest_EdgeValueTesting() {
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
	public void insertSeatsTest_DecisionTableBasedTesting() {
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
	public void removeRowATest_BoundaryValueTesting() {
		p.removeRowA(1);
		assertEquals(false, p.A[1].isAvailable());
		p.removeRowA(2);
		assertEquals(false, p.A[2].isAvailable());
		p.removeRowA(8);
		assertEquals(false, p.A[8].isAvailable());
		p.removeRowA(69);
		assertEquals(false, p.A[69].isAvailable());
		p.removeRowA(70);
		assertEquals(false, p.A[70].isAvailable());
	}

	@Test
	public void removeRowATest_EquivalenceTesting() {
		p.removeRowA(1);
		assertEquals(false, p.A[1].isAvailable());
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
	public void removeRowATest_DecisionTableBasedTesting() {
		p.removeRowA(1);
		assertEquals(false, p.A[1].isAvailable());
	}

	@Test
	public void removeRowBTest_BoundaryValueTesting() {
		p.removeRowB(45);
		assertEquals(false, p.B[45].isAvailable());
		p.removeRowB(46);
		assertEquals(false, p.B[46].isAvailable());
		p.removeRowB(47);
		assertEquals(false, p.B[47].isAvailable());
		p.removeRowB(69);
		assertEquals(false, p.B[69].isAvailable());
		p.removeRowB(70);
		assertEquals(false, p.B[70].isAvailable());
	}

	@Test
	public void removeRowBTest_EquivalenceTesting() {
		p.removeRowB(45);
		assertEquals(false, p.B[45].isAvailable());
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
	public void removeRowBTest_DecisionTableBasedTesting() {
		p.removeRowB(45);
		assertEquals(false, p.B[45].isAvailable());
	}

	@Test
	public void removeRowCTest_BoundaryValueTesting() {
		p.removeRowC(1);
		assertEquals(false, p.C[1].isAvailable());
		p.removeRowC(2);
		assertEquals(false, p.C[2].isAvailable());
		p.removeRowC(8);
		assertEquals(false, p.C[8].isAvailable());
		p.removeRowC(69);
		assertEquals(false, p.C[69].isAvailable());
		p.removeRowC(70);
		assertEquals(false, p.C[70].isAvailable());
	}

	@Test
	public void removeRowCTest_EquivalenceTesting() {
		p.removeRowC(1);
		assertEquals(false, p.C[1].isAvailable());
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
	public void removeRowCTest_DecisionTableBasedTesting() {
		p.removeRowC(1);
		assertEquals(false, p.C[1].isAvailable());
	}

	@Test
	public void removeRowDTest_BoundaryValueTesting() {
		p.removeRowD(27);
		assertEquals(false, p.D[27].isAvailable());
		p.removeRowD(28);
		assertEquals(false, p.D[28].isAvailable());
		p.removeRowD(29);
		assertEquals(false, p.D[29].isAvailable());
		p.removeRowD(69);
		assertEquals(false, p.D[69].isAvailable());
		p.removeRowD(70);
		assertEquals(false, p.D[70].isAvailable());
	}

	@Test
	public void removeRowDTest_EquivalenceTesting() {
		p.removeRowD(27);
		assertEquals(false, p.D[27].isAvailable());
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
	public void removeRowDTest_DecisionTableBasedTesting() {
		p.removeRowD(27);
		assertEquals(false, p.D[27].isAvailable());
	}

	@Test
	public void removeRowETest_BoundaryValueTesting() {
		p.removeRowE(27);
		assertEquals(false, p.E[27].isAvailable());
		p.removeRowE(28);
		assertEquals(false, p.E[28].isAvailable());
		p.removeRowE(29);
		assertEquals(false, p.E[29].isAvailable());
		p.removeRowE(69);
		assertEquals(false, p.E[69].isAvailable());
		p.removeRowE(70);
		assertEquals(false, p.E[70].isAvailable());
	}

	@Test
	public void removeRowETest_EquivalenceTesting() {
		p.removeRowE(27);
		assertEquals(false, p.E[27].isAvailable());
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
	public void removeRowETest_DecisionTableBasedTesting() {
		p.removeRowE(27);
		assertEquals(false, p.E[27].isAvailable());
	}

	@Test
	public void removeRowFTest_BoundaryValueTesting() {
		p.removeRowF(27);
		assertEquals(false, p.F[27].isAvailable());
		p.removeRowF(28);
		assertEquals(false, p.F[28].isAvailable());
		p.removeRowF(29);
		assertEquals(false, p.F[29].isAvailable());
		p.removeRowF(69);
		assertEquals(false, p.F[69].isAvailable());
		p.removeRowF(70);
		assertEquals(false, p.F[70].isAvailable());
	}

	@Test
	public void removeRowFTest_EquivalenceTesting() {
		p.removeRowF(27);
		assertEquals(false, p.F[27].isAvailable());
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
	public void removeRowFTest_DecisionTableBasedTesting() {
		p.removeRowF(27);
		assertEquals(false, p.F[27].isAvailable());
	}

	@Test
	public void removeRowGTest_BoundaryValueTesting() {
		p.removeRowG(27);
		assertEquals(false, p.G[27].isAvailable());
		p.removeRowG(28);
		assertEquals(false, p.G[28].isAvailable());
		p.removeRowG(29);
		assertEquals(false, p.G[29].isAvailable());
		p.removeRowG(69);
		assertEquals(false, p.G[69].isAvailable());
		p.removeRowG(70);
		assertEquals(false, p.G[70].isAvailable());
	}

	@Test
	public void removeRowGTest_EquivalenceTesting() {
		p.removeRowG(27);
		assertEquals(false, p.G[27].isAvailable());
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
	public void removeRowGTest_DecisionTableBasedTesting() {
		p.removeRowG(27);
		assertEquals(false, p.G[27].isAvailable());
	}

	@Test
	public void removeRowHTest_BoundaryValueTesting() {
		p.removeRowH(1);
		assertEquals(false, p.H[1].isAvailable());
		p.removeRowH(2);
		assertEquals(false, p.H[2].isAvailable());
		p.removeRowH(8);
		assertEquals(false, p.H[8].isAvailable());
		p.removeRowH(69);
		assertEquals(false, p.H[69].isAvailable());
		p.removeRowH(70);
		assertEquals(false, p.H[70].isAvailable());
	}

	@Test
	public void removeRowHTest_EquivalenceTesting() {
		p.removeRowH(1);
		assertEquals(false, p.H[1].isAvailable());
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
	public void removeRowHTest_DecisionTableBasedTesting() {
		p.removeRowH(1);
		assertEquals(false, p.H[1].isAvailable());
	}

	@Test
	public void removeRowJTest_BoundaryValueTesting() {
		p.removeRowJ(45);
		assertEquals(false, p.J[45].isAvailable());
		p.removeRowJ(46);
		assertEquals(false, p.J[46].isAvailable());
		p.removeRowJ(47);
		assertEquals(false, p.J[47].isAvailable());
		p.removeRowJ(69);
		assertEquals(false, p.J[69].isAvailable());
		p.removeRowJ(70);
		assertEquals(false, p.J[70].isAvailable());
	}

	@Test
	public void removeRowJTest_EquivalenceTesting() {
		p.removeRowJ(45);
		assertEquals(false, p.J[45].isAvailable());
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
	public void removeRowJTest_DecisionTableBasedTesting() {
		p.removeRowJ(45);
		assertEquals(false, p.J[45].isAvailable());
	}

	@Test
	public void removeRowKTest_BoundaryValueTesting() {
		p.removeRowK(1);
		assertEquals(false, p.K[1].isAvailable());
		p.removeRowK(2);
		assertEquals(false, p.K[2].isAvailable());
		p.removeRowK(8);
		assertEquals(false, p.K[8].isAvailable());
		p.removeRowK(69);
		assertEquals(false, p.K[69].isAvailable());
		p.removeRowK(70);
		assertEquals(false, p.K[70].isAvailable());
	}

	@Test
	public void removeRowKTest_EquivalenceTesting() {
		p.removeRowK(1);
		assertEquals(false, p.K[1].isAvailable());
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
	public void removeRowKTest_DecisionTableBasedTesting() {
		p.removeRowK(1);
		assertEquals(false, p.K[1].isAvailable());
	}

	@Test
	public void seatsLeftTest_BoundaryValueTesting() {
		assertEquals(384, p.seatsLeft());
	}

	@Test
	public void seatsLeftTest_EquivalenceTesting() {
		assertEquals(384, p.seatsLeft());
	}
	
	@Test
	public void seatsLeftTest_EdgeValueTesting() {
		assertEquals(384, p.seatsLeft());
	}

	@Test
	public void seatsLeftTest_DecisionTableBasedTesting() {
		assertEquals(384, p.seatsLeft());
	}
	
	@Test
	public void seatsLeftTest2_BoundaryValueTesting() {
		assertEquals(220, p.seatsLeft(TYPE.EC));
	}

	@Test
	public void seatsLeftTest2_EquivalenceTesting() {
		assertEquals(220, p.seatsLeft(TYPE.EC));
		assertEquals(120, p.seatsLeft(TYPE.EDC));
		assertEquals(32, p.seatsLeft(TYPE.SBC));
		assertEquals(12, p.seatsLeft(TYPE.SFC));
	}
	
	@Test
	public void seatsLeftTest2_EdgeValueTesting() {
		assertEquals(220, p.seatsLeft(TYPE.EC));
		assertEquals(120, p.seatsLeft(TYPE.EDC));
		assertEquals(32, p.seatsLeft(TYPE.SBC));
		assertEquals(12, p.seatsLeft(TYPE.SFC));
	}

	@Test
	public void seatsLeftTest2_DecisionTableBasedTesting() {
		assertEquals(220, p.seatsLeft(TYPE.EC));
		assertEquals(120, p.seatsLeft(TYPE.EDC));
		assertEquals(32, p.seatsLeft(TYPE.SBC));
		assertEquals(12, p.seatsLeft(TYPE.SFC));
	}

	@Test
	public void registerableTest_BoundaryValueTesting() {
		assertEquals(true, p.registerAble(TYPE.SBC, 1));
		assertEquals(true, p.registerAble(TYPE.SBC, 2));
		assertEquals(true, p.registerAble(TYPE.SBC, 5));
		assertEquals(true, p.registerAble(TYPE.SBC, 31));
		assertEquals(true, p.registerAble(TYPE.SBC, 32));
	}

	@Test
	public void registerableTest_EquivalenceTesting() {
		assertEquals(true, p.registerAble(TYPE.SFC, 1));
		assertEquals(true, p.registerAble(TYPE.SBC, 2));
		assertEquals(true, p.registerAble(TYPE.EDC, 5));
		assertEquals(true, p.registerAble(TYPE.EC, 31));
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
	public void registerableTest_DecisionTableBasedTesting() {
		assertEquals(true, p.registerAble(TYPE.SFC, 1));
		assertEquals(true, p.registerAble(TYPE.SBC, 2));
		assertEquals(true, p.registerAble(TYPE.EDC, 5));
		assertEquals(true, p.registerAble(TYPE.EC, 31));
	}

	@Test
	public void registerTypeTest_BoundaryValueTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 3);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;	

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 219);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;	

		// p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		// p.registerType(TYPE.EC, 220);
		// assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		// p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 3);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 119);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		// p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		// p.registerType(TYPE.EDC, 120);
		// assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		// p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 3);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 31);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		// p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		// p.registerType(TYPE.SBC, 32);
		// assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		// p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 3);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 11);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		// p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		// p.registerType(TYPE.SFC, 12);
		// assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		// p.numberCode++;
	}

	@Test
	public void registerTypeTest_EquivalenceTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 12);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 3);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

	}
	
	@Test
	public void registerTypeTest_EdgeValueTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 219);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		// p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		// p.registerType(TYPE.EC, 220);
		// assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		// p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 119);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;

		// p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		// p.registerType(TYPE.EDC, 120);
		// assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		// p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 31);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		// p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		// p.registerType(TYPE.SBC, 32);
		// assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		// p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 11);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		// p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		// p.registerType(TYPE.SFC, 12);
		// assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		// p.numberCode++;
	}

	@Test
	public void registerTypeTest_DecisionTableBasedTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 2);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SFC, 11);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SFC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.SBC, 3);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.SBC));
		p.numberCode++;

		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EDC, 1);
		assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EDC));
		p.numberCode++;
	}

	@Test
	public void unregisterSeatTest_BoundaryValueTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 1);
		Seat s = p.codeList[p.numberCode].seats[0];
		p.unregisterSeat(s);
		assertEquals(false, p.codeList[0].usable);
	}

	@Test
	public void unregisterSeatTest_EquivalenceTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 1);
		Seat s = p.codeList[p.numberCode].seats[0];
		p.unregisterSeat(s);
		assertEquals(false, p.codeList[0].usable);
	}
	
	@Test
	public void unregisterSeatTest_EdgeValueTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 1);
		Seat s = p.codeList[p.numberCode].seats[0];
		p.unregisterSeat(s);
		assertEquals(false, p.codeList[0].usable);
	}

	@Test
	public void unregisterSeatTest_DecisionTableBasedTesting() {
		p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
		p.registerType(TYPE.EC, 1);
		Seat s = p.codeList[p.numberCode].seats[0];
		p.unregisterSeat(s);
		assertEquals(false, p.codeList[0].usable);
	}
}