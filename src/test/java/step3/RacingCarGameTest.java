package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource({"1, 2", "3, 4", "5, 6"})
    void ready(int carCount, int attemptCount) {
        RacingCarGame racingCarGame = new RacingCarGame();
        //racingCarGame.ready();
        //assertThat(racingCarGame.racingCarList.count()).isEqualTo(carCount);
        //assertThat(racingCarGame.attempt.number).isEqualTo(attemptCount);
    }
}