package javaracingcar;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaRacingCarTest {

    @Test
    void javaRacingCar_Random_범위_0에서_9사이인지() {
        JavaRacingCar racingCar = new JavaRacingCar();

        int result = racingCar.random();

        assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    void javaRacingCar_randomValue_0인_값() {
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(0);

        assertThat(result).isFalse();
    }

    @Test
    void javaRacingCar_randomValue_3인_값() {
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(3);

        assertThat(result).isFalse();
    }

    @Test
    void javaRacingCar_randomValue_4인_값() {
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(4);

        assertThat(result).isTrue();
    }

    @Test
    void javaRacingCar_randomValue_9인_값() {
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(9);

        assertThat(result).isTrue();
    }

    @Test
    void javaRacingCar_randomValue_10인_값() {
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(10);

        assertThat(result).isFalse();
    }

    @Test
    void javaRacingCar_객체_생성_시_step() {
        JavaRacingCar racingCar = new JavaRacingCar();

        assertThat(racingCar.step()).isEqualTo(0);
    }

    @Test
    void javaRacingCar_차대수_입력_시_step() {
        JavaRacingCar racingCar = new JavaRacingCar();

        racingCar.requireCarCount(3);

        assertThat(racingCar.step()).isEqualTo(1);
    }

    @Test
    void javaRacingCar_시도_횟수_입력_시_step() {
        JavaRacingCar racingCar = new JavaRacingCar();

        racingCar.requireCarCount(3);
        racingCar.requireTryCount(5);

        assertThat(racingCar.step()).isEqualTo(2);
    }

    @Test
    void javaRacingCar_차대수_negative_음수() {
        JavaRacingCar racingCar = new JavaRacingCar();

        assertThatThrownBy(() -> racingCar.requireCarCount(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void javaRacingCar_시도_횟수_negative_음수() {
        JavaRacingCar racingCar = new JavaRacingCar();

        assertThatThrownBy(() -> racingCar.requireTryCount(-1)).isInstanceOf(RuntimeException.class);
    }

}
