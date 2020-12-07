package step3.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.racingcar.domain.RacingCar;

public class RacingCarTest {

	@DisplayName("4 이상의 정수 값일 경우 자동차 움직임")
	@Test
	void given_integer_greater_or_equal_four_when_car_move_then_move_distance_increase() {
		RacingCar car = new RacingCar(1);
		car.move(4);
		car.move(3);
		car.move(1);
		car.move(5);
		assertThat(car.getMoveDistance()).isEqualTo(2);
	}

}
