package com.next.step.step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final String INIT_POSITION_VALUE = "-";

    @ParameterizedTest(name = "난수를 입력을 했을 때 자동차가 잘 움직이는지 확인하는 테스트")
    @CsvSource(value = {"1|-", "2|-", "5|--"}, delimiter = '|')
    void moveCar_자동차_움직임_테스트(int randomNum, String expected) {
        Car car = new Car(INIT_POSITION_VALUE);
        car.moveCar(randomNum);
        assertThat(car.position()).isEqualTo(expected);
    }
}
