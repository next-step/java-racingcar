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
	private static final String FIXED_CAR_NAME = "fixed";

	@DisplayName("car 이름이 5보다 클 경우 IllegalArgumentException 발생")
	@ParameterizedTest(name = "{index}. 길이가 5보다 큰 car name : {0}")
	@ValueSource(strings = {"car-name", "nameOfCar", "invalidName"})
	void createWithInvalidCarName(String nameOfCar) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Car.create(nameOfCar));
	}

	@DisplayName("MoveRule 이 true 일 때 move() 호출시 변경된 포지션 검증")
	@ParameterizedTest(name = "{index}. nameOfCar : {0}, countOfMove : {1}")
	@CsvSource({"a,1", "b,5", "c,9"})
	void moveWithFixedTrueMoveRule(String nameOfCar, int countOfMove) {
		// given
		Car car = Car.create(nameOfCar);
		MoveRule moveRule = new FixedTrueMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			car.move(moveRule);
		}

		// then
		assertThat(car).isEqualTo(new Car(nameOfCar, new Position(countOfMove)));
	}

	@DisplayName("MoveRule 이 false 일 때 move() 호출시 변경되지 않은 포지션 검증")
	@ParameterizedTest(name = "{index}. countOfMove : {0}, position is always 0")
	@ValueSource(ints = {1, 5, 8})
	void moveWithFixedFalseMoveRule(int countOfMove) {
		// given
		Car car = Car.create(FIXED_CAR_NAME);
		MoveRule moveRule = new FixedFalseMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			car.move(moveRule);
		}

		// then
		assertThat(car).isEqualTo(new Car(FIXED_CAR_NAME, new Position(0)));
	}

	@DisplayName("움직였을 경우 변경된 포지션 검증")
	@ParameterizedTest(name = "{index}. nameOfCar : {0}, countOfMove : {1}")
	@CsvSource({"a,1", "b,5", "c,9"})
	void getCurrentPosition(String nameOfCar, int countOfMove) {
		// when
		Car car = Car.create(nameOfCar);
		MoveRule moveRule = new FixedTrueMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			car.move(moveRule);
		}

		int currentPosition = car.getCurrentPosition();

		// then
		assertThat(currentPosition).isEqualTo(countOfMove);
	}

	@DisplayName("동일하게 움직였을 경우 포지션도 동일한지 검증")
	@ParameterizedTest(name = "{index}. nameOfCar : {0}, countOfMove : {1}")
	@CsvSource({"a,1", "b,5", "c,9"})
	void equalsPosition(String nameOfCar, int countOfMove) {
		// when
		Car car = Car.create(FIXED_CAR_NAME);
		Car otherCar = Car.create(nameOfCar);
		MoveRule moveRule = new FixedTrueMoveRule();

		// when
		for (int i = 0; i < countOfMove; i++) {
			car.move(moveRule);
			otherCar.move(moveRule);
		}

		boolean result = car.equalsPosition(otherCar);

		// then
		assertThat(result).isTrue();
	}
}