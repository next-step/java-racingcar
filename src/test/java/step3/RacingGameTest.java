package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingGameTest {

    private RacingGame racingGame;

    @ParameterizedTest
    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @CsvSource(value = {"3,5", "3,3"})
    void start(int tryCount, int carCount) {
        racingGame = new RacingGame(tryCount, carCount);
        racingGame.start();
    }
}