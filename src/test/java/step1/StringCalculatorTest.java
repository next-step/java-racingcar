import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
	
	StringCalculator calculator = new StringCalculator();
	
	@Test
	@DisplayName("요구사항 1 : 덧셈")
	public void test1() {
		int result = calculator.calc("1 + 2");
		
		assertThat(result).isEqualTo(3);
	}
	
	@Test
	@DisplayName("요구사항 2 : 뺄셈")
	public void test2() {
		int result = calculator.calc("10 - 1");
		
		assertThat(result).isEqualTo(9);
	}
	
	@Test
	@DisplayName("요구사항 3 : 곱셈")
	public void test3() {
		int result = calculator.calc("10 * 10");
		
		assertThat(result).isEqualTo(100);
	}
	
	@Test
	@DisplayName("요구사항 4 : 나눗셈")
	public void test4() {
		int result = calculator.calc("5 / 2");
		
		assertThat(result).isEqualTo(2);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "  "})
	@DisplayName("요구사항 5 : 입력 값이 null 이거나 빈 공백 문자열 일 경우 IllegalArgumentException throw")
	public void test5(String input) {
		assertThatIllegalArgumentException().isThrownBy(()->{
			calculator.calc(input);	
		});
	}
	
	@Test
	@DisplayName("요구사항 6 : 사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
	public void test6() {		
		assertThatIllegalArgumentException().isThrownBy(()->{
			calculator.calc("5 ? 2");	
		});
	}
	
	@Test
	@DisplayName("요구사항 7 : 사칙 연산을 모두 포함하는 기능 구현")
	public void test7() {		
		int result = calculator.calc("2 + 3 * 4 / 2");
		
		assertThat(result).isEqualTo(10);
	}	
}
