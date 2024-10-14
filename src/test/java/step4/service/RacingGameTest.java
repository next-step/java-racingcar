package step4.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step4.service.RacingGame.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.race.RaceResult;
import step4.dto.UserInput;
import step4.exception.CarNameLengthUnvalidException;
import step4.exception.CarNameNestedException;

class RacingGameTest {
	private final static int TEST_MOVE_COUNT = 5;
	private final static String TEST_CAR_STRING_WITH_COMMA = "a,b,c,d,e";
	private final static int TEST_CAR_COUNT = TEST_CAR_STRING_WITH_COMMA.split(COMMA_SEPARATOR).length;

	private UserInput userInput;

	@BeforeEach
	void setUp() {
		userInput = new UserInput(TEST_MOVE_COUNT, TEST_CAR_STRING_WITH_COMMA);
	}

	@Test
	@DisplayName("자동차는 입력받은 n번 만큼 이동을 시도하는지 체크하는 테스트")
	void carMoveTest() {
		RaceResult raceResult = race(userInput);
		assertThat(raceResult.getMovedCount()).isEqualTo(TEST_MOVE_COUNT);
	}

	@Test
	@DisplayName("자동차는 입력받은 이름의 개수만큼 생성되는지 체크하는 테스트. (컴마로 구분)")
	void carCountTest() {
		RaceResult raceResult = race(userInput);
		assertThat(raceResult.getNamePositionMapByTime(0).size()).isEqualTo(TEST_CAR_COUNT);
	}

	@Test
	@DisplayName("name의 크기가 5를 초과할 경우 익셉션 발생 테스트")
	void ifNameIsBiggerThant5ExceptionTest() {
		UserInput unvalidUserInput = new UserInput(TEST_MOVE_COUNT, "abcdef");
		assertThatThrownBy(() -> {
			race(unvalidUserInput);
		}).isInstanceOf(CarNameLengthUnvalidException.class);
	}

	@Test
	@DisplayName("빈 이름이 입력되었을경우 익셉션 발생 테스트")
	void emptyNameInputExceptionTest() {
		UserInput unvalidInput = new UserInput(TEST_MOVE_COUNT, ",a,b,c");

		assertThatThrownBy(() -> {
			race(unvalidInput);
		}).isInstanceOf(CarNameLengthUnvalidException.class);
	}

	@Test
	@DisplayName("같은 이름이 입력되었을경우 익셉션 발생 테스트")
	void nestedNameInputExceptionTest() {
		UserInput unvalidInput = new UserInput(TEST_MOVE_COUNT, "a,a,b");
		assertThatThrownBy(() -> {
			race(unvalidInput);
		}).isInstanceOf(CarNameNestedException.class);
	}
}