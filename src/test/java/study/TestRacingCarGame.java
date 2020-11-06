package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestRacingCarGame {
    RacingCarGame racingCarGame;

    @DisplayName("자동차 게임 실행 - Q: assert를 어떻게 해야하지?")
    @ParameterizedTest
    @CsvSource({"1,2", "3,5" })
    void test_run(int cars, int rounds) {
        racingCarGame = new RacingCarGame(cars, rounds);
        racingCarGame.run();
    }
}
