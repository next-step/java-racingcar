package javaracingcarwinner.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void 차_생성_시_이름() {
        RacingCar racingCar = new RacingCar("kwon");

        assertThat(racingCar.name()).isEqualTo("kwon");
    }

    @Test
    void 차_생성_시_기본_위치() {
        RacingCar racingCar = new RacingCar("kwon");

        assertThat(racingCar.location()).isEqualTo(0);
    }

    @DisplayName("3이라 이동하면 안됨")
    @Test
    void 차_random_value_3일시() {
        final MoveStrategy moveStrategy = () -> 3;
        RacingCar racingCar = new RacingCar("kwon");
        racingCar.move(moveStrategy);

        assertThat(racingCar.location()).isEqualTo(0);
    }

    @DisplayName("4이라 이동하면 안됨")
    @Test
    void 차_random_value_4일시() {
        final MoveStrategy moveStrategy = () -> 4;
        RacingCar racingCar = new RacingCar("kwon");
        racingCar.move(moveStrategy);

        assertThat(racingCar.location()).isEqualTo(1);
    }

}
