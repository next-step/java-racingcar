package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.rule.FixedFalseMoveRule;
import racingcar.rule.FixedTrueMoveRule;
import racingcar.rule.MoveRule;

class CarsTest {
	@DisplayName("MoveRule 이 true 일 때 move() 호출시 변경된 포지션 검증")
	@ParameterizedTest(name = "{index}. numberOfCars : {0}, countOfMove : {1}, expectedPosition : {2}")
	@CsvSource({"3,1,1,", "6,3,3", "11,5,5"})
	void moveWithFixedFalseMoveRule(int numberOfCars, int countOfMove, int expectedPosition) {
		// given
		List<Car> expectedCars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			expectedCars.add(new Car(new Position(expectedPosition)));
		}

		Cars cars = Cars.create(numberOfCars);
		MoveRule moveRule = new FixedTrueMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			cars.move(moveRule);
		}

		// then
		assertThat(cars).isEqualTo(Cars.create(expectedCars));
	}

	@DisplayName("MoveRule 이 false 일 때 move() 호출시 변경되지 않은 포지션 검증")
	@ParameterizedTest(name = "{index}. countOfMove : {0}, numberOfCars : {1}, expectedPosition is always 1")
	@CsvSource({"1,2", "5,6", "9,10"})
	void moveWithFixedTrueMoveRule(int countOfMove, int numberOfCars) {
		// given
		Cars cars = Cars.create(numberOfCars);
		MoveRule moveRule = new FixedFalseMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			cars.move(moveRule);
		}

		// then
		assertThat(cars).isEqualTo(new Cars(numberOfCars));
	}
}