package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameTest {

    private RacingGame racingGame;

    @ParameterizedTest
    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @CsvSource(value = {"3,5", "3,3"})
    void race(int tryCount, int carCount) {
        racingGame = new RacingGame(tryCount, carCount);
        assertDoesNotThrow(() -> racingGame.race(tryCount));
    }

    @ParameterizedTest
    @DisplayName("주어진 횟수를 초과하면 예외가 발생한다")
    @CsvSource(value = {"3,5", "3,3"})
    void raceThrowExceptionWhenTryCountIsOver(int tryCount, int carCount) {
        racingGame = new RacingGame(tryCount, carCount);

        int limitOverTryCount = tryCount + 1;
        assertThrows(IllegalStateException.class, () -> racingGame.race(limitOverTryCount));
    }
}