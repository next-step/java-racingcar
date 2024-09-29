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
}
