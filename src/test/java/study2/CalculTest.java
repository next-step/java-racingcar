package study2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculTest {
	
	@DisplayName("input 값")
	@Test
	void StringInputData(String input) {
		assertTrue(!Strings.isBlank(input));
	}
	
	@DisplayName("split test")
	@Test
	void SplitTest(String input) {
		String[] result = input.split(",");
		
		assertThat(result).contains("+");  
			
	}
	@DisplayName("add test")
	@Test
	void addTest(int a, int b) {
		assertEquals(a + b, a + b);
		
	}
	@DisplayName("sub test")
	@Test
	void subTest(int a, int b) {
		assertEquals(a-b, a-b);
	}
	@DisplayName("multi test")
	@Test
	void multiTest(int a, int b) {
		assertEquals(a * b, a * b);
	}
	
	@DisplayName("나눌때 소수 반환 가능")
	@Test
	void divTest(double a, double b) {
		assertEquals((double) a / b, (double) (a / b ));
	}
	
	@DisplayName("공백이거나 null인 경우 함수")
	public static class Strings {
	    public static boolean isBlank(String input) {
	        return input == null || input.trim().isEmpty();
	    }
	}
	@DisplayName("공백이거나 null인 경우 test")
	@ParameterizedTest
	@ValueSource(strings = {"", "  "})
	void inputDataEqualsNullorBlank(String input) {
	    assertTrue(Strings.isBlank(input));
	}
	@DisplayName("공백이거나 null인 경우 test")
	@CsvSource(value = {" 2 + 3 * 4 /2 "}, delimiter = ':')
	void runTest(String str) {
		
	}
	
}
