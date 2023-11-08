package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class RacingGameTest {

	@Test
	void 레이싱_게임_시작시_유저를_입력받아_초기화한다() {
		RacingGame game = new RacingGame("rac1,rac2,rac3");

		assertThat(game.getCars().get(0).getName()).isEqualTo("rac1");
		assertThat(game.getCars().get(1).getName()).isEqualTo("rac2");
		assertThat(game.getCars().get(2).getName()).isEqualTo("rac3");
	}

	@Test
	void 레이싱_전략만큼_차량을_전진시킨다() {
		RacingGame game = new RacingGame("rac1,rac2,rac3");
		MoveStrategy strategy = () -> 4;

		game.play(strategy);

		assertThat(game.getCars().get(0).getLocation()).isEqualTo(1);
		assertThat(game.getCars().get(1).getLocation()).isEqualTo(1);
		assertThat(game.getCars().get(2).getLocation()).isEqualTo(1);
	}

	// hmm...
	@Test
	void 점수를_가장_많이_얻은_유저들이_우승자가_된다() {
		RacingGame game = new RacingGame("rac1,rac2,rac3");
		MoveStrategy strategy = () -> 4;

		game.play(strategy);
		assertThat(game.getWinners().get(0).getName()).isEqualTo("rac1");
		assertThat(game.getWinners().get(1).getName()).isEqualTo("rac2");
		assertThat(game.getWinners().get(2).getName()).isEqualTo("rac3");
	}
}
