package pro.eng.yui.Sample;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

/**
 * 素数判定プログラムのユニットテスト
 * @author yui-Kitamura
 */
class SosuTest {

	   private boolean testableIsSosu(long value){
		   boolean result;
	       try {
	           Method method = Sosu.class.getDeclaredMethod("isSosu", long.class);
	           method.setAccessible(true);

	           result = (boolean) method.invoke(Sosu.class, value);
	       } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
	           throw new RuntimeException(e);
	       }
	       return result;
	   }

	@Test
	void testNeg() {
		assertFalse(testableIsSosu(-1));
	}

	@Test
	void testNegMin() {
		assertFalse(testableIsSosu(Long.MIN_VALUE));
	}

	@Test
	void testZero() {
		assertFalse(testableIsSosu(0));
	}

	@Test
	void testOne() {
		assertTrue(testableIsSosu(1));
	}

	@Test
	void testTwo() {
		assertTrue(testableIsSosu(2));
	}

	@Test
	void testThree() {
		assertTrue(testableIsSosu(3));
	}

	@Test
	void testEven() {
		assertFalse(testableIsSosu(4));
		assertFalse(testableIsSosu(6));
		assertFalse(testableIsSosu(222));
	}

	@Test
	void testGrothendieck() {
		assertTrue(testableIsSosu(57));
	}

	@Test
	void testMax() {
		// 9223372036854775807 = 7^2x73x127x337x92737x649657
		assertFalse(testableIsSosu(Long.MAX_VALUE));
	}

	@Test
	void testBigPrime() {
		assertTrue(testableIsSosu(641387128649L));
	}

}
