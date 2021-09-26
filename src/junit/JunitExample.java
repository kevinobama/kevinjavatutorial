package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class JunitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    @Test
    void demoTestTrue() {
        assertTrue(true);
    }
    
    @Test
    void demoTestSame() {
        assertSame("one","two");
    }

    @Test
    void demoTestEqual() {
        assertEquals("one","one");
    }
}
