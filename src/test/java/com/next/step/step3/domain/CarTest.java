package com.next.step.step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest(name = "난수를 입력을 했을 때 자동차가 잘 움직이는지 확인하는 테스트")
    @CsvSource(value = {"1|0", "2|0", "5|1"}, delimiter = '|')
    void moveCar_자동차_움직임(int randomNum, int expected) {
        Car car = new Car(0, "car");
        car.moveCar(randomNum);
        assertThat(car.position()).isEqualTo(expected);
    }
}
