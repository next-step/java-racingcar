package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @Test
    @DisplayName("임계값 이상의 숫자를 넘기면 레이싱카는 움직인다.")
    void testMove() {
        final int overMoveThreshold = RacingCar.MOVE_THRESHOLD + 1;
        final RacingCar racingCar = new RacingCar();
        racingCar.move(overMoveThreshold);
        assertThat(racingCar.currentPosition()).isEqualTo(1);
    }

//    @Test
//    @DisplayName("시도 제한횟수를 초과하여 움직이면 예외가 발생한다.")
//    void testTryLimit() {
//        final RacingCar racingCar = new RacingCar(RacingTryCountInput.from(3));
//        assertThatThrownBy(() -> {
//            racingCar.isMove(RacingGameUtils.generateRandomNumber());
//            racingCar.isMove(RacingGameUtils.generateRandomNumber());
//            racingCar.isMove(RacingGameUtils.generateRandomNumber());
//            racingCar.isMove(RacingGameUtils.generateRandomNumber());
//        }).isExactlyInstanceOf(RacingGameException.class);
//    }
//
//    @Test
//    @DisplayName("시도 횟수만큼 히스토리가 쌓인다.")
//    void testCheckHistories() {
//        final RacingCar racingCar = new RacingCar(RacingTryCountInput.from(3));
//        racingCar.isMove(RacingGameUtils.generateRandomNumber());
//        racingCar.isMove(RacingGameUtils.generateRandomNumber());
//        assertThat(racingCar.currentHistories()).hasSize(2);
//    }
}