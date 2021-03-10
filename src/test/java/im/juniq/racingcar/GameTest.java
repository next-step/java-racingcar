package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {
	@DisplayName("자동차 n대를 생성한다")
	@ParameterizedTest
	@ValueSource(ints = {5})
	void createRacingCars(int numberOfCarsToBuild) {
		Game game = new Game();
		game.createCars(numberOfCarsToBuild);
		List<RacingCar> cars = game.getCars();

		assertThat(game.getCars().size()).isEqualTo(numberOfCarsToBuild);

		for (int i = 0; i < cars.size(); i++) {
			RacingCar racingCar = cars.get(i);
			assertThat(racingCar.getId()).isEqualTo(i);
			assertThat(racingCar.getMoveCount()).isEqualTo(0);
		}
	}

	@DisplayName("자동차 n대를 이동한다")
	@ParameterizedTest
	@ValueSource(ints = {5})
	void moveRacingCars(int numberOfCars) throws NoSuchFieldException, IllegalAccessException {
		Game game = new Game();
		game.createCars(numberOfCars);
		List<RacingCar> cars = game.getCars();
		for (RacingCar racingCar: cars) {
			RacingCarTest.setMoveMustBeSuccess(racingCar);
		}

		game.moveCars();

		for (int i = 0; i < cars.size(); i++) {
			RacingCar racingCar = cars.get(i);
			assertThat(racingCar.getId()).isEqualTo(i);
			assertThat(racingCar.getMoveCount()).isEqualTo(1);
		}
	}
}