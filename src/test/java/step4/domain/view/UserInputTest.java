package step4.domain.view;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.exception.RaceParamUnvalidException;

class UserInputTest {
	@Test
	@DisplayName("moveCount 입력이 잘못되었을경우 익셉션 발생 테스트")
	void unExpectedMoveCountInputExceptionTest() {
		assertThatThrownBy(() -> {
			new UserInput(-1, "a");
		}).isInstanceOf(RaceParamUnvalidException.class);
	}

	@Test
	@DisplayName("빈 이름이 입력되었을경우 익셉션 발생 테스트")
	void emptyNameInputExceptionTest() {
		assertThatThrownBy(() -> {
			new UserInput(1, ",,,a,b,c,d,e");
		}).isInstanceOf(RaceParamUnvalidException.class);
	}

	@Test
	@DisplayName("빈 String이 입력되었을경우 익셉션 발생 테스트")
	void emptyStringNameInputExceptionTest() {
		assertThatThrownBy(() -> {
			new UserInput(1, "");
		}).isInstanceOf(RaceParamUnvalidException.class);
	}

	@Test
	@DisplayName("nameString이 null 일경우 익셉션 발생 테스트")
	void nullNameInputExceptionTest() {
		assertThatThrownBy(() -> {
			new UserInput(1, null);
		}).isInstanceOf(RaceParamUnvalidException.class);
	}

	@Test
	@DisplayName("name의 크기가 5를 초과할 경우 익셉션 발생 테스트")
	void ifNameIsBiggerThant5ExceptionTest() {
		assertThatThrownBy(() -> {
			new UserInput(1, "hellos");
		}).isInstanceOf(RaceParamUnvalidException.class);
	}
}