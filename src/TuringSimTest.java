import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TuringSimTest {
	
	private TuringTape t;
	private TuringTape t2;
	private TuringSim ts;
	private TuringSim ts2;
	
	@Test
	public void test() {
		t = new TuringTape();
		char [] vals = new char[8];
		vals[0] = 'a';
		vals[1] = 'a';
		vals[2] = 'b';
		vals[3] = 'b';
		vals[4] = 'a';
		vals[5] = 'a';
		vals[6] = 'b';
		vals[7] = 'b';
		ts = new TuringSim();
		ts.writeInput(vals);
		assertTrue(ts.accepts());
	}
	
	@Test
	public void test2(){
		t2 = new TuringTape();
		char [] vals2 = new char[5];
		vals2[0] = 'a';
		vals2[1] = 'b';
		vals2[2] = 'a';
		vals2[3] = 'a';
		vals2[4] = 'b';
		
		ts2 = new TuringSim();
		ts2.writeInput(vals2);
		assertFalse(ts2.accepts());
	}

}
