package racingcar.domain.aggregate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.asset.ExceptionConst;
import racingcar.exeption.GameOverException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingGameTest {

    @Test
    @DisplayName("gameOver 되었음에도 race 를 하면, GameOverException 이 발생한다.")
    void race() {
        String nameCsv = "1,2,3";
        int maxRaceNum = 2;
        RacingGame game = new RacingGame(nameCsv, maxRaceNum);
        assertThatExceptionOfType(GameOverException.class)
                .isThrownBy(() -> {
                    game.race();
                    game.race();
                    game.race();
                    game.race();
                }).withMessageMatching(ExceptionConst.GAME_OVER_MSG);
    }

    @ParameterizedTest
    @DisplayName("maxRaceNum 보다 많이 race 하면 gameOver 되어야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void play(int loop) {
        String nameCsv = "1,2,3";
        int maxRaceNum = 5;
        RacingGame game = new RacingGame(nameCsv, maxRaceNum);

        for (int i = 0; i < loop; i++) {
            game.race();
        }

        boolean expectedGameOver = loop >= maxRaceNum;
        assertThat(game.checkGameOver())
                .isEqualTo(expectedGameOver);
    }
}
