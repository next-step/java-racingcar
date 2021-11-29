package study.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	@Test
	@DisplayName("레이싱게임 생성 테스트")
	void create() {
		//given
		List<Name> names = Arrays.asList(new Name("a"), new Name("b"), new Name("c"));
		RacingGame racingGame = new RacingGame(names, 5);
		//when
		Cars racing = racingGame.racing(() -> true);
		List<Name> winner = racing.findWinner();
		int maxPosition = racing.maxPosition();
		//then
		assertThat(winner).containsOnly(new Name("a"), new Name("b"), new Name("c"));
		assertThat(maxPosition).isEqualTo(5);
	}
}