package carRacing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("random값이 4이상일 경우 한 칸 전진한다")
	@Test
	void moveCar() {
		Car car = new Car();
		Random random = new Random();
		int randomNum = random.nextInt(6) + 4;

		assertThat(car.moveCar(randomNum)).isEqualTo(1);
	}

	@DisplayName("random값이 4미만일 경우 차는 그대로 서있는다")
	@Test
	void stopCar() {
		Car car = new Car();
		Random random = new Random();
		int randomNum = random.nextInt(4);

		assertThat(car.moveCar(randomNum)).isEqualTo(0);
	}
}