package javaracingcarwinner.entity;

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


}
