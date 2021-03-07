package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.racingcar.controller.RacingCarController;
import camp.nextstep.edu.racingcar.entity.Car;
import camp.nextstep.edu.racingcar.module.RacingCarGame;

public class RacingCarGameTest {

	private static RacingCarGame racingCarGame = RacingCarGame.getInstance();

	private List<String> getMockCarNamesByRange(int maxRange) {
		return IntStream.range(0, maxRange)
			.mapToObj(String::valueOf)
			.collect(Collectors.toList());
	}

	@ParameterizedTest
	@DisplayName("자동차 대수 control")
	@CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
	void 자동차_대수_확인(int input, int expected) {

		List<String> carNames = getMockCarNamesByRange(input);
		List<Car> cars = racingCarGame.generateCars(carNames);

		assertThat(cars.size()).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("시도할 횟수")
	@ValueSource(ints = {1, 2, 3})
	void 시도_횟수(int input) {

		// given
		List<String> carNames = getMockCarNamesByRange(input);
		List<Car> cars = racingCarGame.generateCars(carNames);

		// when
		IntStream.range(0, input)
			.forEach(index -> {
				racingCarGame.moveCars(cars);
			});

		// then
		cars.forEach(car -> assertThat(car.getStep()).isGreaterThanOrEqualTo(0));
	}

	@Test
	@DisplayName("Racing Car game 진행")
	void Racing_car_game_run() {
		// given
		List<String> carNames = getMockCarNamesByRange(2);
		List<Car> cars = racingCarGame.generateCars(carNames);
		int attempt = 5;

		// when
		IntStream.range(0, attempt)
			.forEach((i) -> racingCarGame.moveCars(cars));

		// then
		cars.forEach(car -> {
			assertThat(car.getStep()).isGreaterThanOrEqualTo(0);
		});
	}

	List<Car> getMockCars() {
		Car crong = new Car("crong");
		Car honux = new Car("honux");
		Car pobi = new Car("pobi");

		crong.move(() -> true);
		crong.move(() -> true);
		crong.move(() -> true);

		return Arrays.asList(crong, honux, pobi);
	}

	@Test
	@DisplayName("우승자 step 찾기 (우승자 step 3)")
	void winner_step() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		List<Car> cars = getMockCars();

		// when
		Method method = racingCarGame.getClass().getDeclaredMethod("getWinnerStep", List.class);
		method.setAccessible(true);

		// then
		int expected = 3;
		assertThat(method.invoke(racingCarGame, cars))
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("우승자 이름은 바로 crong~")
	void winner_Name() {
		// given
		List<Car> cars = getMockCars();

		// when
		String winner = racingCarGame.getWinnerNames(cars);

		// then
		String expected = "crong";
		assertThat(winner)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("Racing Car Controller getCarNames Test")
	void Racing_Car_Controller_getCarNames_Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		RacingCarController controller = new RacingCarController();

		// when
		Method method = controller.getClass().getDeclaredMethod("getCarNames", String.class);
		method.setAccessible(true);

		// then
		assertThat(method.invoke(controller, "1,2,3"))
			.isEqualTo(Arrays.asList("1", "2", "3"));
	}
}
