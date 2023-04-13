package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final String INVALID_CAR_NAME = "too much long name";

    @Test
    @DisplayName("자동차 이름이 5글자 이상인 경우 객체 생성시 예외를 발생시킨다")
    void carCreateFailTest() {
        assertThatThrownBy(() -> new Car(INVALID_CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}