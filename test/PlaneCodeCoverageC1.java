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

public class PlaneCodeCoverageC1 {

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
    public void bootTest_CodeCoverageC1() {
        assertEquals(true, p.seatList[0].equals(p.A));
    }

    @Test
    public void insertSeatsTest_CodeCoverageC1() {
        assertEquals("A1", p.A[1].seatName);
    }

    @Test
    public void removeRowATest_CodeCoverageC1() {
        p.removeRowA(1);
        assertEquals(false, p.A[1].isAvailable());
    }

    @Test
    public void removeRowBTest_CodeCoverageC1() {
        p.removeRowB(45);
        assertEquals(false, p.B[45].isAvailable());
    }

    @Test
    public void removeRowCTest_CodeCoverageC1() {
        p.removeRowC(1);
        assertEquals(false, p.C[1].isAvailable());
    }

    @Test
    public void removeRowDTest_CodeCoverageC1() {
        p.removeRowD(27);
        assertEquals(false, p.D[27].isAvailable());
    }

    @Test
    public void removeRowETest_CodeCoverageC1() {
        p.removeRowE(27);
        assertEquals(false, p.E[27].isAvailable());
    }

    @Test
    public void removeRowFTest_CodeCoverageC1() {
        p.removeRowF(27);
        assertEquals(false, p.F[27].isAvailable());
    }

    @Test
    public void removeRowGTest_CodeCoverageC1() {
        p.removeRowG(27);
        assertEquals(false, p.G[27].isAvailable());
    }

    @Test
    public void removeRowHTest_CodeCoverageC1() {
        p.removeRowH(1);
        assertEquals(false, p.H[1].isAvailable());
    }

    @Test
    public void removeRowJTest_CodeCoverageC1() {
        p.removeRowJ(45);
        assertEquals(false, p.J[45].isAvailable());
    }

    @Test
    public void removeRowKTest_CodeCoverageC1() {
        p.removeRowK(1);
        assertEquals(false, p.K[1].isAvailable());
    }

    @Test
    public void seatsLeftTest_CodeCoverageC1() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(383, p.seatsLeft());
    }

    @Test
    public void seatsLeftTest2_CodeCoverageC1() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
        p.registerType(TYPE.EC, 1);
        assertEquals(true, p.codeList[p.numberCode].seats[0].seatType.equals(TYPE.EC));
        p.numberCode++;

        assertEquals(219, p.seatsLeft(TYPE.EC));
    }

    @Test
    public void registerableTest_CodeCoverageC1() {
        assertEquals(true, p.registerAble(TYPE.EC, 1));
        assertEquals(false, p.registerAble(TYPE.EC, 221));
    }

    @Test
    public void unregisterSeatTest_CodeCoverageC1() {
        p.codeList[p.numberCode] = new RandomCode(p.numberCode + 1);
        p.registerType(TYPE.EC, 1);
        Seat s = p.codeList[p.numberCode].seats[0];

        p.unregisterSeat(s);
        assertEquals(false, p.codeList[0].usable);
    }
}