package carracing.controlstatement;

import carracing.controlstatement.Boolean.SmartFalse;
import carracing.controlstatement.Boolean.SmartTrue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IFTest {
	@Test
	void booleanValue_true_true() {
		Boolean b = new IF(new SmartTrue());

		assertThat(b.booleanValue()).isTrue();
	}

	@Test
	void booleanValue_false_false() {
		Boolean b = new IF(new SmartFalse());

		assertThat(b.booleanValue()).isFalse();
	}
}
