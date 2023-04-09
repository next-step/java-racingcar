package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest(name = "[{index}] Cars 1급 객체 1 이상의 정수 입력일 경우 객체를 정상적으로 생성한다.")
    @ValueSource(ints = {1,2,3,4,5})
    void createCarsSuccessTest(int valueSource) {
        Cars cars = new Cars(valueSource);
        assertThat(cars.carSize()).isEqualTo(valueSource);
    }

    @ParameterizedTest(name = "[{index}] Cars 1급 객체 0 이하의 숫자 생성자에 유입된 경우 익셉션을 발생 시킨다.")
    @ValueSource(ints = {0,-1,-2})
    void createCarsFailTest(int valueSource) {
        assertThatThrownBy(() -> {
            new Cars(valueSource);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 보다 작은 수의 차량은 생성될 수 없습니다.");
    }


}