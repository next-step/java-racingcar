package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarsTest {

    @ParameterizedTest(name = "[{index}] Cars 객체에 (,) 구분자를 기준으로 이름만큼 자동차를 생성한다.")
    @CsvSource(value = {"rick,jack,ethan:3","ethan:1","jack,ethan:2"}, delimiter = ':')
    void createCarsSuccessTest(String valueSource, int expectedCarSize) {
        Cars cars = new Cars(new CarNameChunk(valueSource));
        assertThat(cars.carSize()).isEqualTo(expectedCarSize);
    }

    @ParameterizedTest(name = "[{index}] Cars 1급 객체 0 이하의 숫자 생성자에 유입된 경우 익셉션을 발생 시킨다.")
    @NullAndEmptySource
    void createCarsFailTest(String valueSource) {
        assertThatThrownBy(() -> {
            new Cars(new CarNameChunk(valueSource));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름이 임력되지 않았습니다.");
    }

}