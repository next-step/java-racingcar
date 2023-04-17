package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.service.GameRule;

public class GameRuleTest {
	@DisplayName("올바른 숫자 테스트")
	@Test
	void acceptableValue() {
		assertEquals(5, GameRule.isAcceptableValue("5"));
	}

	@DisplayName("음수 입력 테스트")
	@Test
	void negativeInput() {
		assertThrows(RuntimeException.class, () -> GameRule.isAcceptableValue("-1"));
	}

	@DisplayName("문자열 입력 테스트")
	@Test
	void invalidInput() {
		assertThrows(RuntimeException.class, () -> GameRule.isAcceptableValue("abc"));
	}

	@DisplayName("입력 값에 따른 이동 여부 테스트")
	@Test
	void isCarMoving() {
		assertTrue(GameRule.isCarMoving(4));
		assertTrue(GameRule.isCarMoving(7));
		assertFalse(GameRule.isCarMoving(3));
		assertFalse(GameRule.isCarMoving(0));
	}

	@DisplayName("랜덤 값 범위 테스트")
	@Test
	void randomValue() {
		for (int i = 0; i < 100; i++) {
			int randomValue = GameRule.randomValue();
			assertTrue(randomValue >= 0 && randomValue < 10);
		}
	}


	@DisplayName("차 이름 긴 경우 입력 테스트")
	@Test
	void invalidCarNameInput() {
		assertThrows(RuntimeException.class, () -> GameRule.isNameLengthAcceptable("abc,poobiii,errormessage"));
	}

}
