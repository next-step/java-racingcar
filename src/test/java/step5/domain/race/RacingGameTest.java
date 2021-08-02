package step5.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RacingGameTest {

    private static final int GAME_COUNT = 1;

    @ParameterizedTest
    @DisplayName("race()는 RaceResult를 리턴한다")
    @ValueSource(strings = {"a", "a,b", "a,b,c", "a,b,c,d"})
    void race(String input) {
        String[] carNames = input.split(",");
        RacingGame racingGame = new RacingGame(carNames, GAME_COUNT);
        RaceResult raceResult = racingGame.race();

        assertThat(raceResult).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("게임이 끝난 경우 isFinished()는 true를 리턴한다")
    @CsvSource(value = {"a:b:c,5"})
    void isFinished(String input, int gameCount) {
        String[] carNames = input.split(":");

        RacingGame racingGame = new RacingGame(carNames, gameCount);

        racingGame.race();
        assertFalse(racingGame.isFinished());

        racingGame.race();
        assertFalse(racingGame.isFinished());

        racingGame.race();
        assertFalse(racingGame.isFinished());

        racingGame.race();
        assertFalse(racingGame.isFinished());

        racingGame.race();
        assertTrue(racingGame.isFinished());
    }
}