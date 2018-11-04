package racingGame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void 주어진_파라미터에_맞게_게임이_정상_생성된다() {
        int countOfCars = 3;

        RacingGame game = new RacingGame(countOfCars, 5);

        assertThat(game.hasNextRound()).isTrue();
        assertThat(game.getCarsInGame().size()).isEqualTo(countOfCars);
    }

    @Test
    public void move_전부_소진시_다음_라운드_진행이_불가능하다() {
        RacingGame game = new RacingGame(1, 0);

        assertThat(game.hasNextRound()).isFalse();
    }

    @Test
    public void 라운드_진행시_move_가_소진된다() {
        RacingGame game = new RacingGame(1, 1);

        game.move();

        assertThat(game.hasNextRound()).isFalse();
    }
}