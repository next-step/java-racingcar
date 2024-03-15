package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
	@Test
	@DisplayName("시도 횟수와 함께 Car를 초기화하면, 해당 횟수가 할당된다.")
	void setCar() {
		Car car = new Car(3);
		assertThat(car.getMoving()).hasSize(3);
	}
}
