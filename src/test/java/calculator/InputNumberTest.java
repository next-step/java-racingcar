package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputNumberTest {

	@Test
	@DisplayName("InputNumber의 equals()와 hashCode() Test")
	void createInputNumber() {
		InputNumber input = new InputNumber("3");
		assertThat(input).isEqualTo(new InputNumber("3"));
	}

	@Test
	@DisplayName("입력값이 null일 경우 IllegalArgumentException을 throw 한다")
	void InputIsNullThrowsException() {
		assertThatThrownBy(() -> {
			InputNumber input = new InputNumber(null);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException을 throw 한다")
	void InputIsNullOrEmptySpaceThrowsException() {
		assertThatThrownBy(() -> {
			InputNumber input = new InputNumber(" ");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
