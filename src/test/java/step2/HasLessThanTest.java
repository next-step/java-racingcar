package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HasLessThanTest {
	private static final int ZERO = 0;

	@Test
	void hasLessThanIsTrue() {
		final String[] left = {"-1", "2", "3"};
		HasLessThan hasLessThan = new HasLessThan(left, 0);
		assertThat(hasLessThan.booleanValue()).isTrue();
	}

	@Test
	void hasLessThanIsFalse() {
		final String[] left = {"0", "2", "3"};
		HasLessThan hasLessThan = new HasLessThan(left, 0);
		assertThat(hasLessThan.booleanValue()).isFalse();
	}
}
