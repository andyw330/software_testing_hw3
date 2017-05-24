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

public class RandomCodePathTest {

	RandomCode r;
	Seat[] seats;

	private ByteArrayOutputStream outContent;

	private void setUpStreams() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

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
	public void addSeatTest_CodeCoverageC0() {
		for (int i = 0; i < 192; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(192, r.numberSeats());
	}

	@Test
	public void addSeatTest_CodeCoverageC1() {
		for (int i = 0; i < 192; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(192, r.numberSeats());
	}

	@Test
	public void addSeatTest_CodeCoverageC2() {
		for (int i = 0; i < 192; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(192, r.numberSeats());
	}

	@Test
	public void addSeatTest_CodeCoverageMCDC() {
		for (int i = 0; i < 192; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(192, r.numberSeats());
	}

	@Test
	public void removeSeatTest_CodeCoverageC0() {
		for (int i = 0; i < 384; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(384, r.numberSeats());

		r.removeSeat(seats[0]);
		assertEquals(383, r.numberSeats());

		for (int i = 1; i < 383; ++i) {
			r.removeSeat(seats[i]);
		}
		assertEquals(1, r.numberSeats());
	}

	@Test
	public void removeSeatTest_CodeCoverageC1() {
		for (int i = 0; i < 384; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(384, r.numberSeats());

		r.removeSeat(seats[0]);
		assertEquals(383, r.numberSeats());

		for (int i = 1; i < 383; ++i) {
			r.removeSeat(seats[i]);
		}
		assertEquals(1, r.numberSeats());
	}

	@Test
	public void removeSeatTest_CodeCoverageC2() {
		for (int i = 0; i < 384; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(384, r.numberSeats());

		r.removeSeat(seats[0]);
		assertEquals(383, r.numberSeats());

		for (int i = 1; i < 383; ++i) {
			r.removeSeat(seats[i]);
		}
		assertEquals(1, r.numberSeats());
	}

	@Test
	public void removeSeatTest_CodeCoverageMCDC() {
		for (int i = 0; i < 384; ++i) {
			r.addSeat(seats[i]);
		}
		assertEquals(384, r.numberSeats());

		r.removeSeat(seats[0]);
		assertEquals(383, r.numberSeats());

		for (int i = 1; i < 383; ++i) {
			r.removeSeat(seats[i]);
		}
		assertEquals(1, r.numberSeats());
	}

	@Test
	public void unregisterCodeTest_CodeCoverageC0() {
		r.unregisterCode();
		assertEquals(0, r.numberSeats());
		assertEquals(false, r.usable);
	}

	@Test
	public void unregisterCodeTest_CodeCoverageC1() {
		r.unregisterCode();
		assertEquals(0, r.numberSeats());
		assertEquals(false, r.usable);
	}

	@Test
	public void unregisterCodeTest_CodeCoverageC2() {
		r.unregisterCode();
		assertEquals(0, r.numberSeats());
		assertEquals(false, r.usable);
	}

	@Test
	public void unregisterCodeTest_CodeCoverageMCDC() {
		r.unregisterCode();
		assertEquals(0, r.numberSeats());
		assertEquals(false, r.usable);
	}

	@Test
	public void getCodeTest_CodeCoverageC0() {
		r = new RandomCode(1);
		assertEquals(1, r.getCode());
	}

	@Test
	public void getCodeTest_CodeCoverageC1() {
		r = new RandomCode(1);
		assertEquals(1, r.getCode());
	}

	@Test
	public void getCodeTest_CodeCoverageC2() {
		r = new RandomCode(1);
		assertEquals(1, r.getCode());
	}

	@Test
	public void getCodeTest_CodeCoverageMCDC() {
		r = new RandomCode(1);
		assertEquals(1, r.getCode());
	}

	@Test
	public void showCodeTest_CodeCoverageC0() {
		setUpStreams();
		r = new RandomCode(1);
		r.showCode();
		assertEquals("00000001", outContent.toString());
	}

	@Test
	public void showCodeTest_CodeCoverageC1() {
		setUpStreams();
		r = new RandomCode(1);
		r.showCode();
		assertEquals("00000001", outContent.toString());
	}

	@Test
	public void showCodeTest_CodeCoverageC2() {
		setUpStreams();
		r = new RandomCode(1);
		r.showCode();
		assertEquals("00000001", outContent.toString());
	}

	@Test
	public void showCodeTest_CodeCoverageMCDC() {
		setUpStreams();
		r = new RandomCode(1);
		r.showCode();
		assertEquals("00000001", outContent.toString());
	}
}