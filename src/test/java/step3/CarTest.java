package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("Car : 자동차의 상태, 이동로직 등을 각각 객체화하기 위한 클래스")
class CarTest {

	@DisplayName("checkIfMove : 자동차가 움직일 수 있으면 true, 없으면 false를 반환함. true의 비율은 약 60%.")
	@Test
	void checkIfMove() {
		int totalCount = 100000;
		int moveCount = 0;
		Car car = new Car();
		for (int i = 0; i < totalCount; i++) {
			moveCount += car.checkIfMove() ? 1 : 0;
		}
		assertThat(moveCount)
			.isGreaterThan(55000)
			.isLessThan(65000);
	}

	@DisplayName("getLocation : 자동차의 현재 위치를 가져올 수 있음. 최초 위치는 0.")
	@Test
	void getLocation() {
		assertThat(new Car().getLocation()).isEqualTo(0);
	}

	@DisplayName("tryToMove : 자동차의 이동을 시도할 수 있음. 시도가 성공하면 자동차의 위치가 1 증가함.")
	@RepeatedTest(value = 10)
	void tryToMove() {
		int moveTryCount = 5;
		Car car = new Car();
		for (int i = 0; i < moveTryCount; i++) {
			car.tryToMove();
		}
		int result = car.getLocation();
		System.out.printf("자동차의 이동시도횟수 : %d, 최초위치 : %d, 현재위치 : %d \n", moveTryCount, 0, result);
		assertThat(result)
			.isGreaterThanOrEqualTo(0)
			.isLessThanOrEqualTo(moveTryCount);
	}
}