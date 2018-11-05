package racinggame.domain;

import racinggame.domain.rule.RacingGameRule;

import java.util.stream.Stream;

/**
 * Created by hspark on 04/11/2018.
 */
public class RacingGameTestHelper {
	public static RacingGameRule racingGameRuleByCarName(String... carNames) {
		return car -> {
			for (String carName : carNames) {
				if (car.isEqualName(carName)) {
					return true;
				}
			}
			return false;
		};
	}

	public static String[] createTestData(int dataAmount) {
		return Stream.iterate(0, i -> i + 1).limit(dataAmount).map(i -> "data" + i).toArray(String[]::new);
	}
}
