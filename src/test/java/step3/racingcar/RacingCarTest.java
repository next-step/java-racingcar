package step3.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.racingcar.domain.RacingCar;
import step3.racingcar.domain.RacingCarGenerator;
import step3.racingcar.domain.RacingCars;

public class RacingCarTest {

	@DisplayName("4 이상의 정수 값일 경우 자동차 움직임")
	@Test
	void given_integer_greater_or_equal_four_when_car_move_then_move_distance_increase() {
		RacingCar car = new RacingCar(1);
		car.move(4);
		car.move(5);
		assertThat(car.getMoveDistance()).isEqualTo(2);
	}

	@DisplayName("4 이상의 정수가 아닌 경우 자동차 움직이지 않는다")
	@Test
	void given_integer_less_than_four_when_car_move_then_move_distance_dont_change() {
		RacingCar car = new RacingCar(1);
		car.move(3);
		car.move(3);
		car.move(1);
		car.move(2);
		assertThat(car.getMoveDistance()).isEqualTo(0);
	}

	@DisplayName("레이싱카 일급 콜렉션 생성")
	@Test
	void given_count_when_generate_then_return_racingcars() {
		final int participateCarCount = 3;
		RacingCars racingCars = RacingCarGenerator.generate(participateCarCount);
		assertThat(racingCars.getRacingCars()).hasSize(participateCarCount);
	}

}
