package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.moving.Position;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    @Test
    @DisplayName("우승자인지 확인한다")
    void checkWinner() {
        // given
        RacingCar racingCar = RacingCar.of("blue", Position.of(10));
        // when
        boolean winner = racingCar.isWinner(10);
        // then
        assertTrue(winner);
    }
}
