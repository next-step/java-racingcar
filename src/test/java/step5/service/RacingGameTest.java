package step5.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step5.service.RacingGame.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5.domain.car.Position;
import step5.domain.race.RaceHistory;
import step5.dto.UserInput;
import step5.exception.CarNameLengthUnvalidException;
import step5.exception.CarNameNestedException;

class RacingGameTest {
	private final static int MOVE_COUNT = 3;
	private final static String CAR_NAME_A_B_C_D_E = "a,b,c,d,e";
	private final static int CAR_COUNT = CAR_NAME_A_B_C_D_E.split(COMMA_SEPARATOR).length;

	private UserInput userInput;

	@BeforeEach
	void setUp() {
		userInput = new UserInput(MOVE_COUNT, CAR_NAME_A_B_C_D_E);
	}

	@Test
	@DisplayName("자동차는 입력받은 n번 만큼 이동을 시도하는지 체크하는 테스트")
	void carMoveTest() {
		RaceHistory raceResult = race(userInput);
		assertThat(raceResult.getMovedTime()).isEqualTo(MOVE_COUNT);
	}

	@Test
	@DisplayName("자동차는 입력받은 이름의 개수만큼 생성되는지 체크하는 테스트. (컴마로 구분)")
	void carCountTest() {
		RaceHistory raceResult = race(userInput);
		Map<String, Position> firstHistory = raceResult.getRaceHistoryByTime(0).getCarPositionMap();
		assertThat(firstHistory.keySet().size()).isEqualTo(CAR_COUNT);
	}

	@Test
	@DisplayName("name의 크기가 5를 초과할 경우 익셉션 발생 테스트")
	void ifNameIsBiggerThant5ExceptionTest() {
		UserInput unvalidUserInput = new UserInput(MOVE_COUNT, "abcdef");
		assertThatThrownBy(() -> {
			race(unvalidUserInput);
		}).isInstanceOf(CarNameLengthUnvalidException.class);
	}

	@Test
	@DisplayName("빈 이름이 입력되었을경우 익셉션 발생 테스트")
	void emptyNameInputExceptionTest() {
		UserInput unvalidInput = new UserInput(MOVE_COUNT, ",a,b,c");

		assertThatThrownBy(() -> {
			race(unvalidInput);
		}).isInstanceOf(CarNameLengthUnvalidException.class);
	}

	@Test
	@DisplayName("같은 이름이 입력되었을경우 익셉션 발생 테스트")
	void nestedNameInputExceptionTest() {
		UserInput unvalidInput = new UserInput(MOVE_COUNT, "a,a,b");
		assertThatThrownBy(() -> {
			race(unvalidInput);
		}).isInstanceOf(CarNameNestedException.class);
	}
}