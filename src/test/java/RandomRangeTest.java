import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRangeTest {
	@Test
	void randomNumberBetweenMinAndMax() {
		RandomRange r = new RandomRange(0, 10);
		int actual = r.intValue();

		assertThat(actual).isBetween(0, 10);
	}
}
