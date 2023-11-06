package carracing.controlstatement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IFTest {
	@Test
	void booleanValue_True_True() {
		Boolean b = new IF(new Boolean.SmartTrue());

		assertThat(b.booleanValue()).isTrue();
	}

	@Test
	void booleanValue_False_False() {
		Boolean b = new IF(new Boolean.SmartFalse());

		assertThat(b.booleanValue()).isFalse();
	}
}
