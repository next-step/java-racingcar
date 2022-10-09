package racing.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

	private static final String TEST_CAR_NAME_ONE = "CAR1";
	private static final String TEST_CAR_NAME_TWO = "CAR2";
	private static final String TEST_CAR_NAME_THREE = "CAR3";
	private static final int STANDARD_LOCATION = 5;
	private static final int LOWER_LOCATION = STANDARD_LOCATION - 1;
	private static final RandomNum NOT_MOVE_RANDOM_NUM = new NotMoveRandomNum();

	@DisplayName("우승자 조회 테스트")
	@Test
	void getWinnersOfRacing() {
		Car FirstCar = new Car(TEST_CAR_NAME_ONE, 4, NOT_MOVE_RANDOM_NUM);
		Car SecondCar = new Car(TEST_CAR_NAME_ONE, 3, NOT_MOVE_RANDOM_NUM);
		RacingCars racingCars = new RacingCars(
			List.of(FirstCar, SecondCar)
		);

		List<Car> cars = racingCars.getWinnersOfRacing();

		Assertions.assertThat(cars).containsOnly(FirstCar);
	}

	@DisplayName("복수 우승자 조회 테스트")
	@Test
	void getMaxLocation() {
		Car FirstCar = new Car(TEST_CAR_NAME_ONE, STANDARD_LOCATION, NOT_MOVE_RANDOM_NUM);
		Car SecondCar = new Car(TEST_CAR_NAME_TWO, STANDARD_LOCATION, NOT_MOVE_RANDOM_NUM);
		Car ThirdCar = new Car(TEST_CAR_NAME_THREE, LOWER_LOCATION, NOT_MOVE_RANDOM_NUM);
		RacingCars racingCars = new RacingCars(
			List.of(FirstCar, SecondCar, ThirdCar)
		);

		List<Car> cars = racingCars.getWinnersOfRacing();

		Assertions.assertThat(cars).containsOnly(FirstCar, SecondCar);
	}

}
