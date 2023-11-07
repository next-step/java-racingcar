package carracing.controlstatement;

import carracing.controlstatement.Boolean.SmartFalse;
import carracing.controlstatement.Boolean.SmartTrue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ORTest {
	@Test
	void compareLeftIsTrueAndRightIsTrue() {
		Boolean or = new OR(
				new SmartTrue(),
				new SmartTrue()
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsTrueAndRightIsFalse() {
		Boolean or = new OR(
				new SmartTrue(),
				new SmartFalse()
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsFalseAndRightIsTrue() {
		Boolean or = new OR(
				new SmartFalse(),
				new SmartTrue()
		);

		assertThat(or.booleanValue()).isTrue();
	}

	@Test
	void compareLeftIsFalseAndRightIsFalse() {
		Boolean or = new OR(
				new SmartFalse(),
				new SmartFalse()
		);

		assertThat(or.booleanValue()).isFalse();
	}
}
