package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import im.juniq.racingcar.domain.Car;
import im.juniq.racingcar.domain.OnlyTrueMovingStrategy;
import im.juniq.racingcar.domain.Position;
import im.juniq.racingcar.domain.RandomNumberMovingStrategy;
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

	@DisplayName("자동차 이름은 5글자 이하만 허용한다")
	@ParameterizedTest
	@ValueSource(strings = {"pobi66"})
	void createCarWithCheckCarName(String carName) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Car(carName, new RandomNumberMovingStrategy()));
	}

	@DisplayName("자동차를 이동한다")
	@ParameterizedTest
	@ValueSource(strings = {"pobi"})
	void moveCar(String carName) {
		Car car = new Car(carName, new OnlyTrueMovingStrategy());

		car.move();

		assertThat(car.position()).isEqualToComparingFieldByField(new Position(1));
	}
}
