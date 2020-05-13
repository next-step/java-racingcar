package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("ForwardMoveStrategy는 자동차의 position을 1씩 증가시킨다")
    @Test
    void carForwardMovingTest() {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.move(new ForwardMoveStrategy());
        racingCar.move(new ForwardMoveStrategy());
        racingCar.move(new ForwardMoveStrategy());

        // then
        assertThat(racingCar.getPosition()).isEqualTo(3);
    }

    @DisplayName("StopMoveStrategy는 자동차의 position이 증가하지 않는다")
    @Test
    void carStopMovingTest() {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.move(new StopMoveStrategy());
        racingCar.move(new StopMoveStrategy());
        racingCar.move(new StopMoveStrategy());

        // then
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("RandomMoveFactory에서 랜덤으로 생성된 인스턴스에 따라서 자동차의 포지션이 변경된다")
    @Test
    void carMovingTest() {
        IntStream.range(0, 100).forEach(i -> {
            // given
            RacingCar racingCar = new RacingCar();

            // when
            MoveStrategy moveStrategy = RandomMoveFactory.getInstance();
            racingCar.move(moveStrategy);

            // then
            if (moveStrategy instanceof ForwardMoveStrategy) {
                assertThat(racingCar.getPosition()).isEqualTo(1);
            } else {
                assertThat(racingCar.getPosition()).isEqualTo(0);
            }
        });
    }
}
