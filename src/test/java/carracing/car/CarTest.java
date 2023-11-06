package carracing.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
	private static final int ZERO = 0;
	private static final int MOVING = 1;
	private static final int CAR_NAME_MIN_LENGTH = 1;
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("abc");
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

	@Test
	void newObject_nameLengthMoreThanMax_throwException() {
		String carNameWithMoreThanMax = "a".repeat(Math.max(0, CAR_NAME_MAX_LENGTH)) + "a";

		assertThatThrownBy(
				() -> new Car(carNameWithMoreThanMax)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void newObject_nameLengthLessThanMin_throwException() {
		String carNameWithLessThanMin = "a".repeat(Math.max(0, CAR_NAME_MIN_LENGTH)).substring(0, 0);

		assertThatThrownBy(
				() -> new Car(carNameWithLessThanMin)
		).isInstanceOf(IllegalArgumentException.class);
	}
}

