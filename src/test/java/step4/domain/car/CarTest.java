package step4.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.movestrategy.DefaultRandomMoveStrategy;

public class CarTest {
	private Car car;
	private Integer prevPosition;
	private DefaultRandomMoveStrategy defaultRandomMoveStrategy;

	@BeforeEach
	void setUp() {
		car = new Car("singleCar");
		prevPosition = car.getCurrentPosition();
		defaultRandomMoveStrategy = new DefaultRandomMoveStrategy(new Random());
	}

	@Test
	@DisplayName("movable 값이 True 일때만 움직이는지 확인하는 테스트")
	void carStrategyMoveTest() {
		car.move(true);
		Integer expectedPosition = prevPosition + defaultRandomMoveStrategy.speed();
		assertThat(car.getCurrentPosition()).isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("movable 값이 False 일때는 안 움직이는지 확인하는 테스트")
	void carStrategyStopTest() {
		car.move(false);
		assertThat(car.getCurrentPosition()).isEqualTo(prevPosition);
	}

	@Test
	@DisplayName("전략을 정하지 않을시 기본 전략으로 움직이는지 확인하는 테스트")
	void noStrategyTest() {
		assertThat(car.getMoveStrategy()).isInstanceOf(DefaultRandomMoveStrategy.class);
	}
}
