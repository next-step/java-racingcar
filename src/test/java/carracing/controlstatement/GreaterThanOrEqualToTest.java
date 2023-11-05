package carracing.controlstatement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreaterThanOrEqualToTest {
	@Test
	void compareEqualNumber() {
		GreaterThanOrEqualTo m = new GreaterThanOrEqualTo(1, 1);

		assertThat(m.booleanValue()).isTrue();
	}

	@Test
	void compareGreaterThanNumber() {
		GreaterThanOrEqualTo m = new GreaterThanOrEqualTo(2, 1);

		assertThat(m.booleanValue()).isTrue();
	}

	@Test
	void compareLessThanNumber() {
		GreaterThanOrEqualTo m = new GreaterThanOrEqualTo(1, 2);

		assertThat(m.booleanValue()).isFalse();
	}
}
