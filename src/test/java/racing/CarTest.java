package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	Car car = new Car();

	@Test
	@DisplayName("랜덤값이 4이상인 경우 한 칸 전진한다.")
	void test_forward() {
		assertThat(car.isForward(4)).isTrue();
		assertThat(car.isForward(0)).isFalse();
		assertThat(car.isForward(-1)).isFalse();
	}

}