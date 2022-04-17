package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.view.Results;

class RacingCarGameTest {

	@DisplayName("주어진 횟수 동안 게임이 진행")
	@ValueSource(ints = {5,10,100})
	@ParameterizedTest
	public void When_GivePayCount_Expected_PlaySameCount(int playCount) {
		Cars cars = Cars.of(3);
		RacingCarGame racingCarGame = new RacingCarGame(cars, playCount);
		RandomGenerator randomGenerator = () -> 5;

		Results results = racingCarGame.start(randomGenerator);

		assertThat(results.size()).isEqualTo(playCount);
	}
}