package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private static final String TEST_CAR_NAME = "TEST";

    @DisplayName("ForwardMoveStrategy는 자동차의 position을 1씩 증가시킨다")
    @Test
    void carForwardMovingTest() {
        RacingCar racingCar = RacingCar.create(TEST_CAR_NAME);

        IntStream.range(1, 10).forEach(i -> {
            racingCar.move(new MoveForwardStrategy());
            assertThat(racingCar.getPosition()).isEqualTo(i);
        });
    }

    @DisplayName("StopMoveStrategy는 자동차의 position이 증가하지 않는다")
    @Test
    void carStopMovingTest() {
        RacingCar racingCar = RacingCar.create(TEST_CAR_NAME);

        IntStream.range(1, 10).forEach(i -> {
            racingCar.move(new MoveStopStrategy());
            assertThat(racingCar.getPosition()).isEqualTo(0);
        });
    }

}
