package carracing.controlstatement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EqualTest {
	@Test
	void booleanValue_sameLeftAndRight_true() {
		Boolean sameLeftAndRight = new Equal(10, 10);

		assertThat(sameLeftAndRight.booleanValue()).isTrue();
	}

	@Test
	void booleanValue_differentLeftAndRight_false() {
		Boolean differentLeftAndRight = new Equal(9, 10);

		assertThat(differentLeftAndRight.booleanValue()).isFalse();
	}
}
