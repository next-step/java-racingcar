package study3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	ValidationCheck vc = new ValidationCheck();

	@Test
	@DisplayName("자동차 대수 test")
	void carNumValidationCheck() {
		ValidationCheck vc = new ValidationCheck();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			vc.carNumberCheck(0);
		});
	}

	@Test
	@DisplayName("횟수 test")
	void moveCountValidationCheck() {
		ValidationCheck vc = new ValidationCheck();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			vc.moveCountCheck(0);
		});
	}
}
