package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new FourOrMore(new TestRandomHolder(4)));
    }

    @Test
    @DisplayName("시도 횟수별 자동차의 위치를 기록한다.")
    void race() {
        int carCount = 3;
        int attemptCount = 5;

        RaceResult raceResult = racingGame.race(carCount, attemptCount);

        for (int attempt = 0; attempt < attemptCount; attempt++) {
            for (int car = 0; car < carCount; car++) {
                assertThat(raceResult.getAttemptResults()[attempt].getCarPositions()[car]).isEqualTo(attempt + 1);
            }
        }
    }
}
