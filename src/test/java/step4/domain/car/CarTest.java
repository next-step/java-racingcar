package step4.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.builder.CarBuilder;
import step4.domain.movestrategy.AlwaysMoveStrategy;

public class CarTest {
	private static final int SPEED = 3;

	@Test
	@DisplayName("move 시 speed 만큼 움직이는지 체크하는 함수")
	void carStrategyMoveTest() {
		CarBuilder carBuilder = new CarBuilder();
		Car car = carBuilder
			.setSpeed(SPEED)
			.setStrategy(new AlwaysMoveStrategy())
			.build();
		car.move();
		assertThat(car.getPosition()).isEqualTo(SPEED);
	}

}
