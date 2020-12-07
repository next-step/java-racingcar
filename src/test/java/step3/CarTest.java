package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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
}