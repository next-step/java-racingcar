package javaracingcar.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void racingCar_randomValue_3인_값() {
        RacingCar racingCar = new RacingCar();

        boolean result = racingCar.isMove(3);

        assertThat(result).isFalse();
    }

    @Test
    void racingCar_randomValue_4인_값() {
        RacingCar racingCar = new RacingCar();

        boolean result = racingCar.isMove(4);

        assertThat(result).isTrue();
    }

    @Test
    void racingCar_randomValue_9인_값() {
        RacingCar racingCar = new RacingCar();

        boolean result = racingCar.isMove(9);

        assertThat(result).isTrue();
    }

    @Test
    void racingCar_randomValue_10인_값() {
        RacingCar racingCar = new RacingCar();

        boolean result = racingCar.isMove(10);

        assertThat(result).isFalse();
    }

    @Test
    void racingCar_go() {
        RacingCar racingCar = new RacingCar();

        racingCar.go();
        racingCar.go();

        assertThat(racingCar.moveCount()).isEqualTo(2);
    }

}
