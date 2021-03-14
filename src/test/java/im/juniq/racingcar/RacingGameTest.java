package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {
	@DisplayName("자동차 n대를 생성한다")
	@Test
	void createCars() {
		String[] carNames = {"pobi", "poci"};
		RacingGame racingGame = new RacingGame();
		racingGame.createCars(carNames);
		List<Car> cars = racingGame.getCars();

		assertThat(racingGame.getCars().size()).isEqualTo(carNames.length);

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			assertThat(car.getName()).isEqualTo(carNames[i]);
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}

	@DisplayName("자동차 n대를 이동한다")
	@Test
	void moveCars() {
		String[] carNames = {"pobi", "poci"};
		RacingGame racingGame = new RacingGame();
		racingGame.createCars(carNames);

		racingGame.moveCars(new OnlyTrueMovingStrategy());

		List<Car> cars = racingGame.getCars();
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			assertThat(car.getName()).isEqualTo(carNames[i]);
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}
}
