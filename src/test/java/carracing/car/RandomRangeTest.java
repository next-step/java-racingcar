package carracing.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomRangeTest {
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
	void randomNumberBetweenMinAndMax(int number) {
		RandomRange r = new RandomRange(number, number);
		int actual = r.intValue();

		assertThat(actual).isBetween(0, 9);
	}

	@Test
	void isPossible_LessThan4_False() {
		RandomRange r = new RandomRange(3, 3);
		boolean movingIsPossible = r.isPossible();

		assertThat(movingIsPossible).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 9})
	void isPossible_MoreThanEqualTo4_LessThanEqualTo9_True(int number) {
		RandomRange r = new RandomRange(number, number);
		boolean movingIsPossible = r.isPossible();

		assertThat(movingIsPossible).isTrue();
	}

	@Test
	void isPossible_MoreThan9_ThrowException() {
		RandomRange r = new RandomRange(10, 10);
		assertThatThrownBy(r::isPossible)
				.isInstanceOf(IllegalArgumentException.class);
	}
}
