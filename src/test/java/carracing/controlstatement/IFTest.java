package carracing.controlstatement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IFTest {
	@Test
	void booleanValue_true_true() {
		Boolean b = new IF(new Boolean.SmartTrue());

		assertThat(b.booleanValue()).isTrue();
	}

	@Test
	void booleanValue_false_false() {
		Boolean b = new IF(new Boolean.SmartFalse());

		assertThat(b.booleanValue()).isFalse();
	}
}
