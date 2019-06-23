package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.moving.Position;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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

    @Test
    @DisplayName("잘못된 자동차이름을 입력한경우 예외를 확인한다")
    void testIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    RacingCar racingCar = RacingCar.of(null, Position.of(0));
                    // then
                }).withMessageMatching("invalid racing car name");
    }
}
