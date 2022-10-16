package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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
		Car firstCar = new Car(TEST_CAR_NAME_ONE, 4, NOT_MOVE_RANDOM_NUM);
		Car secondCar = new Car(TEST_CAR_NAME_ONE, 3, NOT_MOVE_RANDOM_NUM);
		RacingCars racingCars = new RacingCars(
			List.of(firstCar, secondCar)
		);

		List<Car> cars = racingCars.getWinnersOfRacing();

		assertThat(cars).containsOnly(firstCar);
	}

	@DisplayName("복수 우승자 조회 테스트")
	@Test
	void getMaxLocation() {
		Car firstCar = new Car(TEST_CAR_NAME_ONE, STANDARD_LOCATION, NOT_MOVE_RANDOM_NUM);
		Car secondCar = new Car(TEST_CAR_NAME_TWO, STANDARD_LOCATION, NOT_MOVE_RANDOM_NUM);
		Car thirdCar = new Car(TEST_CAR_NAME_THREE, LOWER_LOCATION, NOT_MOVE_RANDOM_NUM);
		RacingCars racingCars = new RacingCars(
			List.of(firstCar, secondCar, thirdCar)
		);

		List<Car> cars = racingCars.getWinnersOfRacing();

		assertThat(cars).containsOnly(firstCar, secondCar);
	}

}
