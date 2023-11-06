package carracing.controlstatement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ORTest {
	@Test
	void compareLeftIsTrueAndRightIsTrue() {
		Boolean or = new OR(
				new Boolean.SmartTrue(),
				new Boolean.SmartTrue()
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsTrueAndRightIsFalse() {
		Boolean or = new OR(
				new Boolean.SmartTrue(),
				new Boolean.SmartFalse()
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsFalseAndRightIsTrue() {
		Boolean or = new OR(
				new Boolean.SmartFalse(),
				new Boolean.SmartTrue()
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsFalseAndRightIsFalse() {
		Boolean or = new OR(
				new Boolean.SmartFalse(),
				new Boolean.SmartFalse()
		);

		assertThat(or.booleanValue()).isFalse();
	}
}
