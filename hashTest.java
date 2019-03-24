import static org.junit.Assert.*;

import org.junit.Test;

public class hashTest {

	@Test
	public void test() {
		String pssw = "testpssw";
		hash ps2 = new hash(pssw);
		String hashedpssw = ps2.getHash();
		String correctHash = "c2c5371c517132af74dbeb71af3b0a0eaef0d0f43d7884e80a5d06f0daa52b0dfd0d7a1f6ced8a085935126b762d7fee204b8cba5066a816190773c0ebfaf5a4";
		int value = hashedpssw.compareTo( correctHash );
		assertEquals(value,0);
	}

}
