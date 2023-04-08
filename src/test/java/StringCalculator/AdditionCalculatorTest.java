package StringCalculator;

import static StringCalculator.CalculatorUtils.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 덧셈 계산기 테스트")
public class AdditionCalculatorTest {

	@DisplayName("빈문자열 또는 null 입력 시, 0 반환")
	@Test
	void test1() {
		assertThat(AdditionCalculator.calculate("")).isEqualTo(ZERO);
		assertThat(AdditionCalculator.calculate(null)).isEqualTo(ZERO);
	}

	@DisplayName(",를 구분자로 가지는 문자열 입력 시 각 숫자의 합 반환")
	@Test
	void test2() {
		assertThat(AdditionCalculator.calculate("1,")).isEqualTo(1);
		assertThat(AdditionCalculator.calculate("1,2")).isEqualTo(3);
	}

	@DisplayName(":를 구분자로 가지는 문자열 입력 시 각 숫자의 합 반환")
	@Test
	void test3() {
		assertThat(AdditionCalculator.calculate("1:")).isEqualTo(1);
		assertThat(AdditionCalculator.calculate("1:2")).isEqualTo(3);
	}

	@DisplayName(",와 :를 구분자로 가지는 문자열 입력 시 각 숫자의 합 반환")
	@Test
	void test4() {
		assertThat(AdditionCalculator.calculate("1,2:3")).isEqualTo(6);
	}

	@DisplayName("커스텀 구분자 지정 시 각 숫자의 합 반환")
	@Test
	void test5() {
		assertThat(AdditionCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
	}

	@DisplayName("숫자 이외의 값 또는 음수 전달 시 RuntimeException throw")
	@Test
	void test6() {
		assertThatThrownBy(() -> AdditionCalculator.calculate("*,2")).isInstanceOf(RuntimeException.class);	// 파싱 시, RuntimeException 하위인 NumberFormatException 발생
		assertThatThrownBy(() -> AdditionCalculator.calculate("-1,2")).isInstanceOf(RuntimeException.class);
	}
}
