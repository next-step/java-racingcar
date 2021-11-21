package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource({"1, 2", "3, 4", "5, 6"})
    void ready(int carCount, int attemptCount) {
        RacingCarGame racingCarGame = new RacingCarGame();
        boolean result = racingCarGame.ready(carCount, attemptCount);
        assertThat(result).isTrue();
    }

}