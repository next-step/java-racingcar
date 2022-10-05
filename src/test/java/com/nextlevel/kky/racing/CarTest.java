package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.core.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    static int index = 0;

    @ParameterizedTest
    @CsvSource(value = {"3,4,9:2"}, delimiter = ':')
    void carMoveTest(String given, int expected) {
        String[] splitNumber = given.split(",");

        Car car = new Car(() -> Integer.parseInt(splitNumber[index++]));
        for (int i = 0; i < 3; i++) {
            car.move();
        }

        assertThat(car.getCurrentPosition()).isEqualTo(expected);
    }
}
