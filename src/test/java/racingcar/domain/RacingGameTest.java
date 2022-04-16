package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.InputCar;
import racingcar.dto.InputRoundCount;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("InputCarCount 값이 널일 경우 IllegalArgumentException.class 예외를 반환한다.")
    void carCountNullCheck() {
        assertThatThrownBy(() -> new RacingGame(null, new InputRoundCount("2")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("InputRoundCount 값이 널일 경우 IllegalArgumentException.class 예외를 반환한다.")
    void roundCountNullCheck() {
        assertThatThrownBy(() -> new RacingGame(new InputCar("3"), null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}