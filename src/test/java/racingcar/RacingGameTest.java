package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    @DisplayName("시도 횟수별 자동차의 위치를 기록한다.")
    void race() {
        int carCount = 3;
        int attemptCount = 5;
        MoveStrategy moveStrategy = new FourOrMore();
        RandomHolder randomHolder = new TestRandomHolder(4);

        int[][] result = RacingGame.race(carCount, attemptCount, moveStrategy, randomHolder);

        for (int attempt = 0; attempt < attemptCount; attempt++) {
            for (int car = 0; car < carCount; car++) {
                assertThat(result[attempt][car]).isEqualTo(attempt + 1);
            }
        }
    }
}
