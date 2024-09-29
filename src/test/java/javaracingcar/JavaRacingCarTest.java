package javaracingcar;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaRacingCarTest {

    @Test
    void javaRacingCar_Random_범위_0에서_9사이인지() {
        JavaRacingCar racingCar = new JavaRacingCar();

        int result = racingCar.random();

        assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    void javaRacingCar_randomValue_0인_값(){
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(0);

        assertThat(result).isFalse();
    }

    @Test
    void javaRacingCar_randomValue_3인_값(){
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(3);

        assertThat(result).isFalse();
    }

    @Test
    void javaRacingCar_randomValue_4인_값(){
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(4);

        assertThat(result).isTrue();
    }

    @Test
    void javaRacingCar_randomValue_9인_값(){
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(9);

        assertThat(result).isTrue();
    }

    @Test
    void javaRacingCar_randomValue_10인_값(){
        JavaRacingCar racingCar = new JavaRacingCar();

        boolean result = racingCar.isMove(10);

        assertThat(result).isFalse();
    }

}
