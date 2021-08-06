package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("4이상일 경우 이동")
	void move() {
		Car car = new Car();
		RacingCarMoveStrategy strategy = new RacingCarMoveStrategy(4);
		car.move(strategy);
		Car dummy = new Car(1);
		assertThat(car.getMileage()).isEqualTo(dummy.getMileage());
	}

	@Test
	@DisplayName("3이하일 경우 정지")
	void stop() {
		Car car = new Car();
		RacingCarMoveStrategy strategy = new RacingCarMoveStrategy(3);
		car.move(strategy);
		Car dummy = new Car(0);
		assertThat(car.getMileage()).isEqualTo(dummy.getMileage());
	}
}
