package carracing.controlstatement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ORTest {
	@Test
	void compareLeftIsTrueAndRightIsTrue() {
		Boolean or = new OR(
				new LessThan(1, 2),
				new GreaterThan(2, 1)
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsTrueAndRightIsFalse() {
		Boolean or = new OR(
				new LessThan(1, 2),
				new GreaterThan(1, 2)
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsFalseAndRightIsTrue() {
		Boolean or = new OR(
				new LessThan(2, 1),
				new GreaterThan(2, 1)
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsFalseAndRightIsFalse() {
		Boolean or = new OR(
				new LessThan(2, 1),
				new GreaterThan(1, 2)
		);

		assertThat(or.booleanValue()).isFalse();
	}
}
