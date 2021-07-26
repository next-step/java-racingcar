package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

	@DisplayName("주어진 대수만큼 자동차들을 생성한다.")
	@Test
	void create() {
		String carNames = "pobi,crong,honux";
		Cars cars = Cars.of(carNames, 3);

		List<Car> createdCars = cars.cars();
		List<String> createdCarNames = createdCars.stream()
												.map(Car::getName)
												.collect(Collectors.toList());

		assertThat(createdCars).hasSize(3);
		assertThat(createdCarNames).containsExactly("pobi", "crong", "honux");
	}

	@DisplayName("자동차들이 이동하면 위치가 증가한다.")
	@Test
	void race() {
		String carNames = "pobi,crong,honux";
		Cars cars = Cars.of(carNames, 3);
		cars.move(new AlwaysMoveStrategy());
		List<Integer> carPositions = cars.cars()
										.stream()
										.map(Car::getPosition)
										.collect(Collectors.toList());

		assertThat(carPositions).containsOnly(1);
	}

}