package com.hskim.nextstep.step03.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/*
    com.hskim.nextstep.step03 - ValidationUtils class 테스트
 */
public class ValidationUtilsTest {

    @DisplayName("stringLengthLimit() 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "longlong", "rest", "need"})
    void stringLengthLimitTest(String target) {

        int limit = 3;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.stringLengthLimit(target, limit);
        });
    }
}
