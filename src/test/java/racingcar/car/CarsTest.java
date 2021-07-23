package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.strategy.RandomMoveStrategy;

class CarsTest {

	@DisplayName("주어진 대수만큼 자동차들을 생성한다.")
	@Test
	void create() {
		Cars cars = Cars.of(5, new RandomMoveStrategy());
		assertThat(cars.cars()).hasSize(5);
	}

}