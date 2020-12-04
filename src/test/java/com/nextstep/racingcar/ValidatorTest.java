package com.nextstep.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    @DisplayName("자동차 이름 5자 초과 체크")
    @ParameterizedTest
    @CsvSource({"aaaaa, false", "bbbbbb, true"})
    public void isValidName(String name, boolean expected){
        boolean result = Validator.isInvalidName(name);
        assertThat(result).isEqualTo(expected);
    }
}
