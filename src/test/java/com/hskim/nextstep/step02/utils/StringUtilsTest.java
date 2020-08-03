package com.hskim.nextstep.step02.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
    com.hskim.nextstep.step02 - StringUtils class 테스트
 */
public class StringUtilsTest {

    @DisplayName("받은 문자열이 Numeric인지 판단하는 isNumeric() 메소드 검증")
    @ParameterizedTest
    @CsvSource(value = {"5:true", "2.0:true", "125:true", "-4:true", "a:false", "%:false", ";:false"}, delimiter = ':')
    void isNumericTest(String input, boolean expected) {

        assertThat(StringUtils.isNumeric(input)).isEqualTo(expected);
    }
}
