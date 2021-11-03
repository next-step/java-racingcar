package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.rule.FixedFalseMoveRule;
import racingcar.rule.FixedTrueMoveRule;
import racingcar.rule.MoveRule;

class CarTest {
	@DisplayName("MoveRule 이 true 일 때 move() 호출시 변경된 포지션 검증")
	@ParameterizedTest(name = "{index}. countOfMove : {0}, expectedPosition : {1}")
	@CsvSource({"1,2", "5,6", "9,10"})
	void moveWithFixedTrueMoveRule(int countOfMove, int expectedPosition) {
		// given
		Car car = Car.create();
		MoveRule moveRule = new FixedTrueMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			car.move(moveRule);
		}

		// then
		assertThat(car).isEqualTo(new Car(new Position(expectedPosition)));
	}

	@DisplayName("MoveRule 이 false 일 때 move() 호출시 변경되지 않은 포지션 검증")
	@ParameterizedTest(name = "{index}. countOfMove : {0}, expectedPosition is always 1")
	@ValueSource(ints = {1, 5, 8})
	void moveWithFixedFalseMoveRule(int countOfMove) {
		// given
		Car car = Car.create();
		MoveRule moveRule = new FixedFalseMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			car.move(moveRule);
		}

		// then
		assertThat(car).isEqualTo(new Car(new Position(1)));
	}
}