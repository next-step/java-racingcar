package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import util.RandomUtil;

class CountOfGamePlayTest {

	@DisplayName("주어진 횟수만큼 게임을 실행")
	@ValueSource(ints = {3,10,50})
	@ParameterizedTest
	public void When_GivePlayCount_Expected_RunForCount(int playCount) {
		CountOfGamePlay countOfGamePlay = new CountOfGamePlay(playCount);

		countOfGamePlay.run(Cars.of(5), () -> RandomUtil.createRandomNumber(GameRule.RANDOM_MIN, GameRule.RANDOM_MAX));
	}
}