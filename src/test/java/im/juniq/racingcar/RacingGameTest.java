package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {
	@DisplayName("자동차 n대를 생성한다")
	@ParameterizedTest
	@ValueSource(ints = {5})
	void createRacingCars(int numberOfCarsToBuild) {
		RacingGame racingGame = new RacingGame();
		racingGame.createCars(numberOfCarsToBuild);
		List<Car> cars = racingGame.getCars();

		assertThat(racingGame.getCars().size()).isEqualTo(numberOfCarsToBuild);

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			assertThat(car.getId()).isEqualTo(i);
			assertThat(car.getMoveCount()).isEqualTo(0);
		}
	}

	@DisplayName("자동차 n대를 이동한다")
	@ParameterizedTest
	@ValueSource(ints = {5})
	void moveRacingCars(int numberOfCars) throws NoSuchFieldException, IllegalAccessException {
		RacingGame racingGame = new RacingGame();
		racingGame.createCars(numberOfCars);
		List<Car> cars = racingGame.getCars();
		for (Car car : cars) {
			CarTest.setMoveMustBeSuccess(car);
		}

		racingGame.moveCars();

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			assertThat(car.getId()).isEqualTo(i);
			assertThat(car.getMoveCount()).isEqualTo(1);
		}
	}

	@DisplayName("자동차 이동횟수를 출력한다.")
	@ParameterizedTest
	@ValueSource(ints = {3})
	public void printMoveCount(int numberOfCars) {
		RacingGame racingGame = new RacingGame();
		racingGame.createCars(3);
		racingGame.moveCars();
		racingGame.printCarsMoveCount();

		racingGame.moveCars();
		racingGame.printCarsMoveCount();
	}
}