package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.rule.FixedFalseMoveRule;
import racingcar.rule.FixedTrueMoveRule;
import racingcar.rule.MoveRule;

class CarsTest {
	@DisplayName("MoveRule 이 true 일 때 move() 호출시 변경된 포지션 검증")
	@ParameterizedTest(name = "{index}. numberOfCars : {0}, countOfMove : {1}")
	@CsvSource(value = {"a:1", "a,b:3", "a,b,c:5"}, delimiter = ':')
	void moveWithFixedFalseMoveRule(String nameOfCars, int countOfMove) {
		// given
		Cars cars = createCars(nameOfCars, 0);
		MoveRule moveRule = new FixedTrueMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			cars.move(moveRule);
		}

		// then
		assertThat(cars).isEqualTo(createCars(nameOfCars, countOfMove));
	}

	@DisplayName("MoveRule 이 false 일 때 move() 호출시 변경되지 않은 포지션 검증")
	@ParameterizedTest(name = "{index}. nameOfCars : {0}, countOfMove : {1}, position is always 0")
	@CsvSource(value = {"a:1", "a,b:3", "a,b,c:5"}, delimiter = ':')
	void moveWithFixedTrueMoveRule(String nameOfCars, int countOfMove) {
		// given
		Cars cars = createCars(nameOfCars, 0);
		MoveRule moveRule = new FixedFalseMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			cars.move(moveRule);
		}

		// then
		assertThat(cars).isEqualTo(createCars(nameOfCars, 0));
	}

	@DisplayName("동일하게 움직였을 경우 참가자와 가장 멀리간 자동차가 동일한지 검증")
	@ParameterizedTest(name = "{index}. nameOfCars : {0}, countOfMove : {1}")
	@CsvSource(value = {"a:1", "a,b:3", "a,b,c:5"}, delimiter = ':')
	void getCarNamesWithHighestPosition(String nameOfCars, int countOfMove) {
		// given
		Cars cars = createCars(nameOfCars, countOfMove);
		String[] expectedNames = nameOfCars.split(RacingGame.NAME_OF_CARS_DELIMITER);

		// when
		List<String> carNames = cars.getCarNamesWithHighestPosition();

		// then
		assertThat(carNames).hasSize(expectedNames.length);
		assertThat(carNames).hasSameElementsAs(Arrays.asList(expectedNames));
	}

	private Cars createCars(String nameOfCars, int countOfMove) {
		List<Car> cars = new ArrayList<>();

		String[] names = nameOfCars.split(RacingGame.NAME_OF_CARS_DELIMITER);
		for (String name : names) {
			cars.add(new Car(name, new Position(Position.DEFAULT_POSITION + countOfMove)));
		}

		return Cars.create(cars);
	}
}