package refactoring.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import strategy.ManualMoveable;
import strategy.Moveable;

class CarTest {

	private Car car;

	@BeforeEach
	void init() {
		car = new Car("test");
	}

	@ParameterizedTest
	@CsvSource(value = {"0=true", "1=false", "2=false"}, delimiter = '=')
	@DisplayName("자동차를 생성하면 거리는 기본 0으로 세팅")
	void initCarDefaultDistanceSuccess(int input, boolean expected) {
		assertThat(car.getCarDistance() == input).isEqualTo(expected);
	}

	@Test
	@DisplayName("우승자와 같은 Car 클래스")
	void compareWinnerCar() {
		Moveable moveable = new ManualMoveable();
		Car compareCar = new Car("test2");

		car.move(moveable);
		compareCar.move(moveable);

		assertThat(car.sameWinnerCarDistance(compareCar)).isTrue();

		compareCar.move(moveable);

		assertThat(car.sameWinnerCarDistance(compareCar)).isFalse();
	}
}