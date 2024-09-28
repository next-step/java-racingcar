package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.RacingGameException;
import racinggame.input.RacingTryCountInput;
import racinggame.utils.RacingGameUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @Test
    @DisplayName("시도 제한횟수를 초과하여 움직이면 예외가 발생한다.")
    void testTryLimit() {
        final RacingCar racingCar = new RacingCar(RacingTryCountInput.from(3));
        assertThatThrownBy(() -> {
            racingCar.isMove(RacingGameUtils.generateRandomNumber());
            racingCar.isMove(RacingGameUtils.generateRandomNumber());
            racingCar.isMove(RacingGameUtils.generateRandomNumber());
            racingCar.isMove(RacingGameUtils.generateRandomNumber());
        }).isExactlyInstanceOf(RacingGameException.class);
    }

    @Test
    @DisplayName("시도 횟수만큼 히스토리가 쌓인다.")
    void testCheckHistories() {
        final RacingCar racingCar = new RacingCar(RacingTryCountInput.from(3));
        racingCar.isMove(RacingGameUtils.generateRandomNumber());
        racingCar.isMove(RacingGameUtils.generateRandomNumber());
        assertThat(racingCar.currentHistories()).hasSize(2);
    }
}