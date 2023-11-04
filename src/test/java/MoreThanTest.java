import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoreThanTest {
	@Test
	void compareEqualNumber() {
		MoreThan m = new MoreThan(1, 1);

		assertThat(m.booleanValue()).isTrue();
	}

	@Test
	void compareGreaterThanNumber() {
		MoreThan m = new MoreThan(2, 1);

		assertThat(m.booleanValue()).isTrue();
	}

	@Test
	void compareLessThanNumber() {
		MoreThan m = new MoreThan(1, 2);

		assertThat(m.booleanValue()).isFalse();
	}
}
