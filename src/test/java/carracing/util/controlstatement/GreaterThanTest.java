package carracing.util.controlstatement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreaterThanTest {
	@Test
	void compareEqualNumber() {
		Boolean greaterThan = new GreaterThan(1, 1);

		assertThat(greaterThan.booleanValue()).isFalse();
	}

	@Test
	void compareGreaterThanNumber() {
		Boolean greaterThan = new GreaterThan(2, 1);

		assertThat(greaterThan.booleanValue()).isTrue();
	}

	@Test
	void compareLessThanNumber() {
		Boolean greaterThan = new GreaterThan(1, 2);

		assertThat(greaterThan.booleanValue()).isFalse();
	}
}
