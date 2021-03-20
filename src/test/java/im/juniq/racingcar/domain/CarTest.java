package im.juniq.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
	@DisplayName("자동차를 생성한다")
	@ParameterizedTest
	@ValueSource(strings = {"pobi"})
	void createCar(String carName) {
		assertThatCode(() -> new Car(carName, new RandomNumberMovingStrategy())).doesNotThrowAnyException();
	}

	@DisplayName("자동차를 이동한다")
	@ParameterizedTest
	@ValueSource(strings = {"pobi"})
	void moveCar(String carName) {
		OnlyTrueMovingStrategy movingStrategy = new OnlyTrueMovingStrategy();
		Car car = new Car(carName, movingStrategy);

		car.move();

		assertThat(car.position().value()).isEqualTo(1);
	}
}
