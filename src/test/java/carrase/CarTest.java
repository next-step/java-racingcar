package carrase;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("자동차 전진")
	void carMove() {
		RacingCar car = new RacingCar();
		car.moveForward();

		assertThat(car.getMileage()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 멈춤")
	void carStop() {
		RacingCar car = new RacingCar();
		car.stop();

		assertThat(car.getMileage()).isEqualTo(0);
	}

	@Test
	@DisplayName("전진")
	void move() {
		CarBehavior carBehavior = CarBehavior.getCarBehavior(4);
		RacingCar car = new RacingCar();
		carBehavior.apply(car);

		assertThat(car.getMileage()).isEqualTo(1);
	}

	@Test
	@DisplayName("멈춤")
	void stop() {
		CarBehavior carBehavior = CarBehavior.getCarBehavior(3);
		RacingCar car = new RacingCar();
		carBehavior.apply(car);

		assertThat(car.getMileage()).isEqualTo(0);
	}
}
