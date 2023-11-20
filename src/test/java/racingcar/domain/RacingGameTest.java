package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameResultInfo;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 게임을 실행한다.")
    void startGame() {
        // given
        RacingGame racingGame = new RacingGame(new DoubleRandomService(4), createRacingCars(),
                createNumberOfAttempts());

        // when
        GameResultInfo gameResultInfo = racingGame.startSingleGame();

        // then
        assertThat(gameResultInfo).isEqualTo(createExpectedGameResultInfo());
    }

    private RacingCars createRacingCars() {
        return new RacingCars(Arrays.asList(
                new RacingCar("tobi", 0),
                new RacingCar("pobi", 0),
                new RacingCar("k5", 0)
        ));
    }

    private NumberOfAttempts createNumberOfAttempts() {
        return new NumberOfAttempts(3);
    }

    private GameResultInfo createExpectedGameResultInfo() {
        return new GameResultInfo(createGameResult(), new NumberOfAttempts(2));
    }

    private String createGameResult() {
        return "tobi : -\n"
                + "pobi : -\n"
                + "k5 : -\n"
                + '\n';
    }
}
