package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;

class CarTest {

	@ParameterizedTest(name = "invalidName : {0}")
	@ValueSource(strings = {"", "    "})
	@DisplayName("자동차 이름이 공백이면 예외를 반환한다.")
	void validateNameTest_blankName(String invalidName) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new Car(invalidName))
			.withMessageContaining("자동차 이름은 공백일 수 없습니다.");
	}

	@ParameterizedTest(name = "invalidName : {0}")
	@ValueSource(strings = {"abcdefg", "가나다라마바"})
	@DisplayName("자동차 이름이 5자 초과이면 예외를 반환한다.")
	void validateNameTest_lengthOverFive(String invalidName) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new Car(invalidName))
			.withMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
	}

	@Test
	@DisplayName("자동차의 초기 위치는 0이다.")
	void initialLocationTest() {
		// given
		Car car = new Car("tdd");

		// when
		int initLocation = car.getLocation();

		// then
		assertThat(initLocation).isZero();
	}

	@Test
	@DisplayName("전진 조건을 만족하면 전진한다.")
	void goTest_go() {
		// given
		Car car = new Car("tdd");

		// when
		car.go(() -> true);

		// then
		assertThat(car.getLocation()).isEqualTo(1);
	}

	@Test
	@DisplayName("전진 조건을 만족하지 않으면 정지한다.")
	void goTest_stop() {
		// given
		Car car = new Car("tdd");

		// when
		car.go(() -> false);

		// then
		assertThat(car.getLocation()).isEqualTo(0);
	}

}
