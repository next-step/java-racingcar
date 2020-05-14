package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("ForwardMoveStrategy는 자동차의 position을 1씩 증가시킨다")
    @Test
    void carForwardMovingTest() {
        RacingCar racingCar = RacingCar.create(1);

        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(1);
        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(2);
        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(3);
    }

    @DisplayName("StopMoveStrategy는 자동차의 position이 증가하지 않는다")
    @Test
    void carStopMovingTest() {
        RacingCar racingCar = RacingCar.create(1);

        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
    }

    @DisplayName("RandomMoveFactory에서 랜덤으로 생성된 인스턴스에 따라서 자동차의 포지션이 변경된다")
    @Test
    void carMovingTest() {
        IntStream.range(0, 100).forEach(i -> {
            RacingCar racingCar = RacingCar.create(i);

            MoveStrategy moveStrategy = RandomMoveFactory.getInstance();

            if (moveStrategy instanceof ForwardMoveStrategy) {
                assertThat(racingCar.move(moveStrategy)).isEqualTo(1);
            } else {
                assertThat(racingCar.move(moveStrategy)).isEqualTo(0);
            }
        });
    }
}
