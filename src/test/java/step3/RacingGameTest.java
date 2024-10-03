package step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step3.RacingGame.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
	@Test
	@DisplayName("자동차는 입력받은 n대 만큼 생성되는지 체크하는 테스트")
	void carCountTest() {
		Car[] cars = inputCars(4);
		for (Car car : cars) {
			assertThat(car).isNotNull();
		}
		assertThat(cars).hasSize(4);
	}

	@Test
	@DisplayName("자동차는 입력받은 n번 만큼 이동을 시도하는지 체크하는 테스트")
	void carMoveTest() {
		Car[] cars = inputCars(4);
		int moveCount = 5;
		race(cars, moveCount);
		for (Car car : cars) {
			assertThat(car.getMoveTimes()).isEqualTo(moveCount);
		}
	}
}