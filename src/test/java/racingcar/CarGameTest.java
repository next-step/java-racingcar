package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.racingcar.entity.Car;
import camp.nextstep.edu.racingcar.module.RacingCarGame;

public class CarGameTest {

	private static RacingCarGame racingCarGame = new RacingCarGame();

	@ParameterizedTest
	@DisplayName("자동차 대수 control")
	@CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
	void 자동차_대수_확인(int input, int expected) {

		List<Car> cars = racingCarGame.generateCars(input);

		assertThat(cars.size()).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("시도할 횟수 control 무조건 move 시키는 전제 조건")
	@ValueSource(ints = {1, 2, 3})
	void 시도_횟수(int input) {

		// given
		List<Car> cars = racingCarGame.generateCars(5);

		// when
		IntStream.range(0, input)
			.forEach(index -> {
				racingCarGame.moveCars(cars, 5);
			});

		// then
		cars.forEach(car -> assertThat(car.getStep()).isEqualTo(input));
	}

	@Test
	@DisplayName("Racing Car game 진행 무조건 무브")
	void Racing_car_game_run() {
		// given
		List<Car> cars = racingCarGame.generateCars(2);
		int attempt = 5;
		int randomNumber = 5;

		// when
		IntStream.range(0, attempt)
			.forEach((i) ->  racingCarGame.moveCars(cars, randomNumber));


		// then
		cars.forEach(car -> {
			assertThat(car.getStep()).isEqualTo(attempt);
		});
	}



}
