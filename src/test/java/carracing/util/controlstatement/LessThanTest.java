package carracing.util.controlstatement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LessThanTest {
	@Test
	void compareEqualNumber() {
		Boolean lessThan = new LessThan(1, 1);

		assertThat(lessThan.booleanValue()).isFalse();
	}

	@Test
	void compareGreaterThanNumber() {
		Boolean lessThan = new LessThan(2, 1);

		assertThat(lessThan.booleanValue()).isFalse();
	}

	@Test
	void compareLessThanNumber() {
		Boolean lessThan = new LessThan(1, 2);

		assertThat(lessThan.booleanValue()).isTrue();
	}
}
