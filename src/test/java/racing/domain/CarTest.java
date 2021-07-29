package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

	@ParameterizedTest
	@DisplayName("이름을 입력하면 해당 이름이 반환된다.")
	@CsvSource(value = {"car1", "car2", "car3"})
	public void returnCarName(String value) {
		Car car = new Car(value);
		String playerName = car.printCarName();

		assertThat(playerName).isEqualTo(value);
	}

	@Test
	@DisplayName("결과값의 따라 자동차가 움직인다.")
	public void carRacingConditionCheck() {
		Car car = new Car("car1");

		car.move(new DummyFalseRandomMove());
		assertThat(car.printPosition()).isEqualTo(0);

		car.move(new DummyTrueRandomMove());
		assertThat(car.printPosition()).isEqualTo(1);
	}

	@ParameterizedTest
	@DisplayName("이름이 5글자 이상이면 예외처리가 발생된다.")
	@CsvSource(value = {"smith", "tester", "freeze"})
	public void nameLengthCheck(String value) {
		assertThrows(IllegalArgumentException.class, () ->
			new Car(value)
		);
	}

	@Test
	@DisplayName("경주에서 최고값이 해당 위치와 일치하면 true 그렇지 않으면 false 를 반환한다.")
	public void isWinnerCheck() {
		int maxPosition = 3;
		Car car = new Car("car");
		car.move(new DummyTrueRandomMove());
		car.move(new DummyTrueRandomMove());

		assertThat(car.isWinner(maxPosition)).isFalse();

		car.move(new DummyTrueRandomMove());
		assertThat(car.isWinner(maxPosition)).isTrue();
	}

	@Test
	@DisplayName("랜덤값은 0이상 10미만의 값을 반환한다.")
	public void randomValueCheck() {
		Car car = new Car("car");

		int result = car.randomValue();

		assertThat(result).isGreaterThanOrEqualTo(0).isLessThan(10);
	}

	private static class DummyFalseRandomMove extends RandomMoving {
		@Override
		public boolean movable(int randomValue) {
			return false;
		}
	}

	private static class DummyTrueRandomMove extends RandomMoving {
		@Override
		public boolean movable(int randomValue) {
			return true;
		}
	}

}