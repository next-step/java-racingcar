package step4.domain.view;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.dto.UserInput;
import step4.exception.RaceParamUnvalidException;

class UserInputTest {
	private static final int VALID_MOVE_COUNT = 1;
	private static final int UNVALID_MOVE_COUNT = -1;
	private static final String VALID_NAME_STRING = "a,b,c";

	@Test
	@DisplayName("moveCount 입력이 잘못되었을경우 익셉션 발생 테스트")
	void unExpectedMoveCountInputExceptionTest() {
		assertThatThrownBy(() -> {
			new UserInput(UNVALID_MOVE_COUNT, VALID_NAME_STRING);
		}).isInstanceOf(RaceParamUnvalidException.class);
	}

	@Test
	@DisplayName("빈 String이 입력되었을경우 익셉션 발생 테스트")
	void emptyStringNameInputExceptionTest() {
		assertThatThrownBy(() -> {
			new UserInput(VALID_MOVE_COUNT, "");
		}).isInstanceOf(RaceParamUnvalidException.class);
	}

	@Test
	@DisplayName("nameString이 null 일경우 익셉션 발생 테스트")
	void nullNameInputExceptionTest() {
		assertThatThrownBy(() -> {
			new UserInput(VALID_MOVE_COUNT, null);
		}).isInstanceOf(RaceParamUnvalidException.class);
	}
}