package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.domain.Cars;
import step4_racingcar_winner.service.GameRule;
import step4_racingcar_winner.service.RandomNumber;

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
		assertThrows(RuntimeException.class, () -> new Cars(new String[] {"abc", "poobiii", "errormessage"}));
	}

}
