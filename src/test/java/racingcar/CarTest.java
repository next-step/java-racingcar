package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@Test
	@DisplayName("자동차의 초기 위치는 0이다.")
	void initialLocationTest() {
		// when
		int initLocation = car.getLocation();

		// then
		assertThat(initLocation).isZero();
	}

	@Test
	@DisplayName("전진 조건을 만족하면 전진한다.")
	void goTest_go() {
		// when
		car.go(() -> true);

		// then
		assertThat(car.getLocation()).isEqualTo(1);
	}

	@Test
	@DisplayName("전진 조건을 만족하지 않으면 정지한다.")
	void goTest_stop() {
		// when
		car.go(() -> false);

		// then
		assertThat(car.getLocation()).isEqualTo(0);
	}

}
