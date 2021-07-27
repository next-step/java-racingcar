package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

	@DisplayName("주어진 대수만큼 자동차들을 생성한다.")
	@Test
	void create() {
		String carNames = "pobi,crong,honux";
		Cars cars = Cars.of(carNames);

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
		Cars cars = Cars.of(carNames);
		cars.move(new AlwaysMoveStrategy());
		List<Integer> carPositions = cars.cars()
										.stream()
										.map(Car::getCarPosition)
										.collect(Collectors.toList());

		assertThat(carPositions).containsOnly(1);
	}

	@DisplayName("우승자를 구한다.")
	@Test
	void raceWinners() {
		Car pobi = new Car(new CarName("pobi"), new CarPosition(3));
		Car crong = new Car(new CarName("crong"), new CarPosition(3));
		Car honux = new Car(new CarName("honux"), new CarPosition(2));

		Cars cars = Cars.of(Arrays.asList(pobi, crong, honux));
		List<Car> winners = cars.getRaceWinners();

		assertThat(winners).containsExactly(pobi, crong);
	}

}