package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
    @Test
    @DisplayName("경주에 참여할 자동차 수를 음수로 넘기면 실패한다.")
    void 자동차_수_음수_실패() {
        Assertions.assertThatThrownBy(() -> RacingCars.create(-1))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(RacingCarErrorCode.CAR_NUMBER_BAD_REQUEST.getMessage());
    }
}
