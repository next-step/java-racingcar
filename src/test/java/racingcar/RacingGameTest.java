package racingcar;

import org.junit.Test;
import racingcar.domain.RacingGame;
import racingcar.view.GameResult;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void 초기화() {
        String namesOfCar = "aaa,bbb,ccc";
        RacingGame game = new RacingGame(namesOfCar);

        assertThat(game.getNumberOfCars()).isEqualTo(3);
    }

    @Test
    public void 게임하기() {
        String namesOfCar = "aaa,bbb,ccc";
        RacingGame game = new RacingGame(namesOfCar);

        int time = 5;
        GameResult result = game.play(time);

        assertThat(result.countRoundLength()).isEqualTo(time);
    }
}