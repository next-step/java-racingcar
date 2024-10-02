package javaracingcarwinner.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void 차_생성_시_이름() {
        RacingCar racingCar = new RacingCar("woogie");

        assertThat(racingCar.name()).isEqualTo("woogie");
    }

    @Test
    void 차_생성_시_기본_위치() {
        RacingCar racingCar = new RacingCar("woogie");

        assertThat(racingCar.location()).isEqualTo(0);
    }

    @Test
    void 차_이동_판단_VALUE_3() {
        RacingCar racingCar = new RacingCar("woogie");

        boolean result = racingCar.isMove(3);

        assertThat(result).isFalse();
    }

    @Test
    void 차_이동_판단_VALUE_4() {
        RacingCar racingCar = new RacingCar("woogie");

        boolean result = racingCar.isMove(4);

        assertThat(result).isTrue();
    }

    @Test
    void 차_이동_판단_VALUE_9() {
        RacingCar racingCar = new RacingCar("woogie");

        boolean result = racingCar.isMove(9);

        assertThat(result).isTrue();
    }

    @Test
    void 차_이동_시() {
        RacingCar racingCar = new RacingCar("woogie");

        racingCar.go().go();

        assertThat(racingCar.location()).isEqualTo(2);
    }
}
