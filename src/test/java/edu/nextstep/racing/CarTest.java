package edu.nextstep.racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Car : 자동차의 상태, 이동로직 등을 각각 객체화하기 위한 클래스")
class CarTest {

	@DisplayName("checkIfMove : Car객체에 정의된 numberGenerator가 생성한 값이 STOP_LIMIT_NUMBER인 4 이상이면 true 리턴.")
	@ParameterizedTest
	@CsvSource(value = {"3, false", "4, true", "5, true"})
	void checkIfMove(int number, boolean result) {
		Car car = new Car(() -> number);
		assertThat(car.checkIfMove()).isEqualTo(result);
	}

	@DisplayName("getLocation : 자동차의 현재 위치를 가져올 수 있음. 최초 위치는 0.")
	@Test
	void getLocation() {
		assertThat(new Car().getLocation()).isEqualTo(0);
	}

	@DisplayName("tryToMove : 자동차의 이동을 시도할 수 있음. 시도가 성공하면 자동차의 위치가 1 증가함.")
	@ParameterizedTest
	@CsvSource(value = {"3, 0", "4, 1", "5, 1"})
	void tryToMove(int number, int result) {
		Car car = new Car(() -> number);
		car.tryToMove();
		assertThat(car.getLocation()).isEqualTo(result);
	}
}