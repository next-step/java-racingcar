package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	@Test
	@DisplayName("자동차 객체는 전진하기 위해 랜덤수를 생성하는데, 이 값은 0 ~ 9이다")
	void createRandomNumber() {
		Car car = new Car();

		car.move();

		assertThat(car.getValueToMovable())
			.isGreaterThanOrEqualTo(0)
			.isLessThan(10);
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5})
	@DisplayName("자동차 객체가 생성한 랜덤 값이 4이상 이면 자동차는 전진한다")
	void movableTest(int number) {

	}

}
