package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
	private static final int ZERO = 0;
	private static final int MOVING = 1;

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 9})
	void moveCarSuccessBoundary(int number) {
		car.move(new RandomRange(number, number));

		assertThat(car.movingDistance()).isEqualTo(MOVING);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 3})
	void moveCarFalseBoundary(int number) {
		car.move(new RandomRange(number, number));

		assertThat(car.movingDistance()).isEqualTo(ZERO);
	}

	@Test
	void carTryMovingOutOfRandomRange() {
		assertThatThrownBy(
				() -> car.move(new RandomRange(11, 20))
		).isInstanceOf(IllegalArgumentException.class);
	}
}

