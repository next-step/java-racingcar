package step4.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step4.service.RacingGame.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.car.Car;
import step4.domain.car.CarList;
import step4.domain.view.UserInput;

class RacingGameTest {
	private final static int TEST_MOVE_COUNT = 3;
	private final static String TEST_CAR_STRING = "a,b,c,d,e";

	private UserInput userInput;

	@BeforeEach
	void setUp() {
		userInput = new UserInput(TEST_MOVE_COUNT, TEST_CAR_STRING);
	}

	@Test
	@DisplayName("자동차는 입력받은 n번 만큼 이동을 시도하는지 체크하는 테스트")
	void carMoveTest() {
		CarList carList = race(userInput);
		for (Car car : carList.getList()) {
			assertThat(car.getCarPositionHistory().size()).isEqualTo(TEST_MOVE_COUNT);
		}
	}
}