package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CarNameTest {

    private static final String INVALID_CAR_NAME = "too much long name";

    @Test
    @DisplayName("자동차 이름이 5글자 이상인 경우 객체 생성시 예외를 발생시킨다")
    void carCreateFailTest1() {
        assertThatThrownBy(() -> new CarName(INVALID_CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest(name = "자동차 이름이 빈값인경우 객체 생성시 예외를 발생시킨다. value = {0}")
    @NullAndEmptySource
    void carCreateFailTest2(String source) {
        assertThatThrownBy(() -> new CarName(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름이 임력되지 않았습니다.");
    }
}
