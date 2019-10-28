package step2.domain.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class CarNumberDefaultRuleTest {

	@Test
	void 기본_경기참가_자동차_최소_대수는_1대_이다() {
		// given
		int carNumber = 0;

		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new CarNumberDefaultRule(carNumber);
		});
	}

}
