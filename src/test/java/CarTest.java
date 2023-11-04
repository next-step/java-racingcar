import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
	private final static int ZERO = 0;
	private static final int MOVING = 1;

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@Test
	void carTryMovingSuccess() {
		car.tryMoving(new RandomRange(4, 9));

		assertThat(car.movingDistance()).isEqualTo(MOVING);
	}

	@Test
	void carTryMovingFail() {
		car.tryMoving(new RandomRange(0, 3));

		assertThat(car.movingDistance()).isEqualTo(ZERO);
	}

	@Test
	void carTryMovingOutOfRandomRange() {
		assertThatThrownBy(
				() -> car.tryMoving(new RandomRange(11, 20))
		).isInstanceOf(IllegalArgumentException.class);
	}
}

