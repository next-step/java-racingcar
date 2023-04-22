package step5_racingcar_refactoring;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5_racingcar_refactoring.domain.Cars;
import step5_racingcar_refactoring.service.GameRule;

public class GameRuleTest {
	@DisplayName("시도횟수_올바른 숫자 테스트")
	@Test
	void acceptableValue() {
		assertEquals(5, GameRule.isAcceptableTryValue("5"));
	}

	@DisplayName("시도횟수_음수 입력 테스트")
	@Test
	void negativeInput() {
		assertThrows(RuntimeException.class, () -> GameRule.isAcceptableTryValue("-1"));
	}

	@DisplayName("시도횟수_문자열 입력 테스트")
	@Test
	void invalidInput() {
		assertThrows(RuntimeException.class, () -> GameRule.isAcceptableTryValue("abc"));
	}

	@DisplayName("시도횟수_차 이름 긴 경우 입력 테스트")
	@Test
	void invalidCarNameInput() {
		String[] cars = {"abc", "poobiii", "errormessage"};
		Class expect = RuntimeException.class;
		String expectedMsg = "자동차 이름을 길게 작성했습니다";

		assertThatThrownBy(() -> new Cars(cars))
			.isInstanceOf(expect)
			.hasMessageContaining(expectedMsg);
	}

	@DisplayName("시도횟수_빈값 입력 테스트")
	@Test
	void emptyCarNameInput() {
		String[] cars = {" ", "errormessage"};
		Class expect = RuntimeException.class;
		String expectedMsg = "널이거나 빈값입니다";

		assertThatThrownBy(() -> new Cars(cars))
			.isInstanceOf(expect)
			.hasMessageContaining(expectedMsg);
	}

	@DisplayName("시도횟수_널값 입력 테스트")
	@Test
	void nullCarNameInput() {
		String[] cars = {null, "errormessage"};
		Class expect = RuntimeException.class;
		String expectedMsg = "널이거나 빈값입니다";

		assertThatThrownBy(() -> new Cars(cars))
			.isInstanceOf(expect)
			.hasMessageContaining(expectedMsg);
	}

}
