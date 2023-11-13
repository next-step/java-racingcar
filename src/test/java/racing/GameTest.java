package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.game.Game;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

	Game game;

	static class Return_0_to_9 extends Random {

		@Override
		public int nextInt() {
			return nextInt(10);
		}

	}

	@BeforeEach
	void beforeEach() {
		game = new Game(new Return_0_to_9());
	}

	@Test
	@DisplayName("bound()의 값은 0이상 9이하이다")
	void nextInt() {
		assertThat(game.bounds(1).get(0))
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(9);
	}

	@Test
	@DisplayName("3대의 자동차가 한번에 모두 전진을 시도할 때 필요한 random ArrayList를 만든다")
	void make_random_list() {
		int cars = 3;

		List<Integer> bounds = game.bounds(cars);

		for (int i = 0; i < cars; i++) {
			assertThat(bounds.get(i)).isGreaterThanOrEqualTo(0)
					.isLessThanOrEqualTo(9);
		}
	}


}
