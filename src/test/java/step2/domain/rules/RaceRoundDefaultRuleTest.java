package step2.domain.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class RaceRoundDefaultRuleTest {

	@Test
	void 기본_자동차_경기_최소_라운드는_1회_이다() {
		// given
		int raceRound = 0;

		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new RaceRoundDefaultRule(raceRound);
		});
	}

}
