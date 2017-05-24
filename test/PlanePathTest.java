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

public class PlanePathTest {
	
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
    public void bootTest_CodeCoverageC0() {
        assertEquals(true, p.seatList[0].equals(p.A));
    }

	
    @Test
    public void bootTest_CodeCoverageC1() {
        assertEquals(true, p.seatList[0].equals(p.A));
    }

	
    @Test
    public void bootTest_CodeCoverageC2() {
        assertEquals(true, p.seatList[0].equals(p.A));
    }

	
    @Test
    public void bootTest_CodeCoverageMCDC() {
        assertEquals(true, p.seatList[0].equals(p.A));
    }
	
    
    @Test
    public void insertSeatsTest_CodeCoverageC0() {
        assertEquals("A1", p.A[1].seatName);
    }

    
    @Test
    public void insertSeatsTest_CodeCoverageC1() {
        assertEquals("A1", p.A[1].seatName);
    }

    
    @Test
    public void insertSeatsTest_CodeCoverageC2() {
        assertEquals("A1", p.A[1].seatName);
    }

    
    @Test
    public void insertSeatsTest_CodeCoverageMCDC() {
        assertEquals("A1", p.A[1].seatName);
    }

    
    @Test
    public void removeRowATest_CodeCoverageC0() {
        p.removeRowA(1);
        assertEquals(false, p.A[1].isAvailable());
    }

    
    @Test
    public void removeRowATest_CodeCoverageC1() {
        p.removeRowA(1);
        assertEquals(false, p.A[1].isAvailable());
    }
    
    
    @Test
    public void removeRowATest_CodeCoverageC2() {
        p.removeRowA(1);
        assertEquals(false, p.A[1].isAvailable());
    }
    
    
    @Test
    public void removeRowATest_CodeCoverageMCDC() {
        p.removeRowA(1);
        assertEquals(false, p.A[1].isAvailable());
    }
    
    
    @Test
    public void removeRowBTest_CodeCoverageC0() {
        p.removeRowB(45);
        assertEquals(false, p.B[45].isAvailable());
    }

    
    @Test
    public void removeRowBTest_CodeCoverageC1() {
        p.removeRowB(45);
        assertEquals(false, p.B[45].isAvailable());
    }

    
    @Test
    public void removeRowBTest_CodeCoverageC2() {
        p.removeRowB(45);
        assertEquals(false, p.B[45].isAvailable());
    }

    
    @Test
    public void removeRowBTest_CodeCoverageMCDC() {
        p.removeRowB(45);
        assertEquals(false, p.B[45].isAvailable());
    }

    
    @Test
    public void removeRowCTest_CodeCoverageC0() {
        p.removeRowC(1);
        assertEquals(false, p.C[1].isAvailable());
    }

    
    @Test
    public void removeRowCTest_CodeCoverageC1() {
        p.removeRowC(1);
        assertEquals(false, p.C[1].isAvailable());
    }

    
    @Test
    public void removeRowCTest_CodeCoverageC2() {
        p.removeRowC(1);
        assertEquals(false, p.C[1].isAvailable());
    }

    
    @Test
    public void removeRowCTest_CodeCoverageMCDC() {
        p.removeRowC(1);
        assertEquals(false, p.C[1].isAvailable());
    }

    
    @Test
    public void removeRowDTest_CodeCoverageC0() {
        p.removeRowD(27);
        assertEquals(false, p.D[27].isAvailable());
    }

    
    @Test
    public void removeRowDTest_CodeCoverageC1() {
        p.removeRowD(27);
        assertEquals(false, p.D[27].isAvailable());
    }

    
    @Test
    public void removeRowDTest_CodeCoverageC2() {
        p.removeRowD(27);
        assertEquals(false, p.D[27].isAvailable());
    }

    
    @Test
    public void removeRowDTest_CodeCoverageMCDC() {
        p.removeRowD(27);
        assertEquals(false, p.D[27].isAvailable());
    }

    
    @Test
    public void removeRowETest_CodeCoverageC0() {
        p.removeRowE(27);
        assertEquals(false, p.E[27].isAvailable());
    }

    
    @Test
    public void removeRowETest_CodeCoverageC1() {
        p.removeRowE(27);
        assertEquals(false, p.E[27].isAvailable());
    }

    
    @Test
    public void removeRowETest_CodeCoverageC2() {
        p.removeRowE(27);
        assertEquals(false, p.E[27].isAvailable());
    }

    
    @Test
    public void removeRowETest_CodeCoverageMCDC() {
        p.removeRowE(27);
        assertEquals(false, p.E[27].isAvailable());
    }

    
    @Test
    public void removeRowFTest_CodeCoverageC0() {
        p.removeRowF(27);
        assertEquals(false, p.F[27].isAvailable());
    }

    
    @Test
    public void removeRowFTest_CodeCoverageC1() {
        p.removeRowF(27);
        assertEquals(false, p.F[27].isAvailable());
    }

    
    @Test
    public void removeRowFTest_CodeCoverageC2() {
        p.removeRowF(27);
        assertEquals(false, p.F[27].isAvailable());
    }

    
    @Test
    public void removeRowFTest_CodeCoverageMCDC() {
        p.removeRowF(27);
        assertEquals(false, p.F[27].isAvailable());
    }

    
    @Test
    public void removeRowGTest_CodeCoverageC0() {
        p.removeRowG(27);
        assertEquals(false, p.G[27].isAvailable());
    }

    
    @Test
    public void removeRowGTest_CodeCoverageC1() {
        p.removeRowG(27);
        assertEquals(false, p.G[27].isAvailable());
    }

    
    @Test
    public void removeRowGTest_CodeCoverageC2() {
        p.removeRowG(27);
        assertEquals(false, p.G[27].isAvailable());
    }

    
    @Test
    public void removeRowGTest_CodeCoverageMCDC() {
        p.removeRowG(27);
        assertEquals(false, p.G[27].isAvailable());
    }

    
    @Test
    public void removeRowHTest_CodeCoverageC0() {
        p.removeRowH(1);
        assertEquals(false, p.H[1].isAvailable());
    }

    
    @Test
    public void removeRowHTest_CodeCoverageC1() {
        p.removeRowH(1);
        assertEquals(false, p.H[1].isAvailable());
    }

    
    @Test
    public void removeRowHTest_CodeCoverageC2() {
        p.removeRowH(1);
        assertEquals(false, p.H[1].isAvailable());
    }

    
    @Test
    public void removeRowHTest_CodeCoverageMCDC() {
        p.removeRowH(1);
        assertEquals(false, p.H[1].isAvailable());
    }

    
    @Test
    public void removeRowJTest_CodeCoverageC0() {
        p.removeRowJ(45);
        assertEquals(false, p.J[45].isAvailable());
    }

    
    @Test
    public void removeRowJTest_CodeCoverageC1() {
        p.removeRowJ(45);
        assertEquals(false, p.J[45].isAvailable());
    }

    
    @Test
    public void removeRowJTest_CodeCoverageC2() {
        p.removeRowJ(45);
        assertEquals(false, p.J[45].isAvailable());
    }

    
    @Test
    public void removeRowJTest_CodeCoverageMCDC() {
        p.removeRowJ(45);
        assertEquals(false, p.J[45].isAvailable());
    }

    
    @Test
    public void removeRowKTest_CodeCoverageC0() {
        p.removeRowK(1);
        assertEquals(false, p.K[1].isAvailable());
    }

    
    @Test
    public void removeRowKTest_CodeCoverageC1() {
        p.removeRowK(1);
        assertEquals(false, p.K[1].isAvailable());
    }

    @Test
    public void removeRowKTest_CodeCoverageC2() {
        p.removeRowK(1);
        assertEquals(false, p.K[1].isAvailable());
    }

    @Test
    public void removeRowKTest_CodeCoverageMCDC() {
        p.removeRowK(1);
        assertEquals(false, p.K[1].isAvailable());
    }

    @Test
    public void seatsLeftTest_CodeCoverageC0() {
        assertEquals(384, p.seatsLeft());
    }

    @Test
    public void seatsLeftTest_CodeCoverageC1() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(383, p.seatsLeft());
    }

    @Test
    public void seatsLeftTest_CodeCoverageC2() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(383, p.seatsLeft());
    }

    @Test
    public void seatsLeftTest_CodeCoverageMCDC() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(383, p.seatsLeft());
    }

    @Test
    public void seatsLeftTest2_CodeCoverageC0() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(219, p.seatsLeft(TYPE.EC));
    }

    @Test
    public void seatsLeftTest2_CodeCoverageC1() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(219, p.seatsLeft(TYPE.EC));
    }

    @Test
    public void seatsLeftTest2_CodeCoverageC2() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(219, p.seatsLeft(TYPE.EC));
    }

    @Test
    public void seatsLeftTest2_CodeCoverageMCDC() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(219, p.seatsLeft(TYPE.EC));
    }

    @Test
    public void registerableTest_CodeCoverageC0() {
        assertEquals(true, p.registerAble(TYPE.EC, 1));
        assertEquals(false, p.registerAble(TYPE.EC, 221));
    }

    @Test
    public void registerableTest_CodeCoverageC1() {
        assertEquals(true, p.registerAble(TYPE.EC, 1));
        assertEquals(false, p.registerAble(TYPE.EC, 221));
    }

    @Test
    public void registerableTest_CodeCoverageC2() {
        assertEquals(true, p.registerAble(TYPE.EC, 1));
        assertEquals(false, p.registerAble(TYPE.EC, 221));
    }

    @Test
    public void registerableTest_CodeCoverageMCDC() {
        assertEquals(true, p.registerAble(TYPE.EC, 1));
        assertEquals(false, p.registerAble(TYPE.EC, 221));
    }

    @Test
    public void unregisterSeatTest_CodeCoverageC0() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        Seat s = p.codeList[p.numberCode].seats[0];
        
        p.unregisterSeat(s);
        assertEquals(false, p.codeList[0].usable);
    }

    @Test
    public void unregisterSeatTest_CodeCoverageC1() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        Seat s = p.codeList[p.numberCode].seats[0];
        
        p.unregisterSeat(s);
        assertEquals(false, p.codeList[0].usable);
    }

    @Test
    public void unregisterSeatTest_CodeCoverageC2() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        Seat s = p.codeList[p.numberCode].seats[0];
        
        p.unregisterSeat(s);
        assertEquals(false, p.codeList[0].usable);
    }

    @Test
    public void unregisterSeatTest_CodeCoverageMCDC() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode+1);
        p.registerType(TYPE.EC, 1);
        Seat s = p.codeList[p.numberCode].seats[0];
        
        p.unregisterSeat(s);
        assertEquals(false, p.codeList[0].usable);
    }
}