package racingcar.domain.aggregate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exeption.GameOverException;

class RacingGameTest {

    @ParameterizedTest
    @DisplayName("gameOver 되었음에도 race 를 하면, GameOverException 이 발생한다.")
    @CsvSource(value = {"5:5", "5:4", "5:6"}, delimiter = ':')
    void race(int maxRaceNum, int loop) {
        String nameCsv = "1,2,3";
        RacingGame game = new RacingGame(nameCsv, maxRaceNum);
        Executable executable = () -> {
            for (int i = 0; i < loop; i++) {
                game.race();
            }
        };

        if (maxRaceNum < loop) {
            Assertions.assertThrows(GameOverException.class, executable);
            return;
        }
        Assertions.assertDoesNotThrow(executable);
    }
}
