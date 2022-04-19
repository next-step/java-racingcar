package racingcar.domain;

import util.RandomUtil;

public class EngineRandomStrategy implements EngineStrategy {
	@Override
	public int generate() {
		return RandomUtil.createRandomNumber(GameRule.RANDOM_MIN, GameRule.RANDOM_MAX);
	}
}
