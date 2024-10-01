package step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step2.StringAddCalculator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {
	@Test
	@DisplayName("숫자 String 하나를 넣으면 그 숫자값이 반환되는지 확인하는 테스트.")
	void singleInputTest() {
		assertThat(calculate("1")).isEqualTo(1);
	}

	@Test
	@DisplayName("null이거나 빈 값일 때 0이 반환되는지 확인하는 테스트.")
	void emptyInputTest() {
		assertThat(calculate("")).isEqualTo(0);
		assertThat(calculate(null)).isEqualTo(0);
	}

	@Test
	@DisplayName("기본 구분자인 , 와 :을 넣었을 때 합이 올바르게 반환되는지 확인하는 테스트.")
	void splitDefaultSeperatorTest() {
		assertThat(calculate("1,2,3")).isEqualTo(6);
		assertThat(calculate("1:2:3")).isEqualTo(6);
	}

	@Test
	@DisplayName("커스텀 구분자를 올바른 형식으로 넣었을 때 합이 올바르게 반환되는지 확인하는 테스트.")
	void splitCustomSeperatorTest() {
		assertThat(calculate("//hello\n1hello2,3:4hello7")).isEqualTo(17);
	}

	@Test
	@DisplayName("음수, 올바르지 않은값, 이상한 커스텀 구분자를 넣었을 때 오류가 발생하는지 확인하는 테스트.")
	void unExpectedErrorTest() {
		assertThatThrownBy(() -> calculate("1,-2,3,4")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> calculate("1,-2,이상한값,4")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> calculate("%/unExpectedValue\r1,-2,3,4")).isInstanceOf(RuntimeException.class);
	}
}