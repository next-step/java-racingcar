import carracing.RandomRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRangeTest {
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
	void randomNumberBetweenMinAndMax(int number) {
		RandomRange r = new RandomRange(number, number);
		int actual = r.intValue();

		assertThat(actual).isBetween(0, 9);
	}
}
