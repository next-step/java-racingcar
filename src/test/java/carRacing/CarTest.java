package carRacing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIndexOutOfBoundsException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	@DisplayName("random값이 4이상일 경우 한 칸 전진한다")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void moveCar(int input) {
		Car car = new Car();
		car.moveCar(input);

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("random값이 4미만일 경우 차는 그대로 서있는다")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void stopCar(int input) {
		Car car = new Car();
		car.moveCar(input);

		assertThat(car.getPosition()).isEqualTo(0);
	}
}