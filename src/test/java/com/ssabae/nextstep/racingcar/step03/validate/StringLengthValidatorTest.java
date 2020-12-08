package com.ssabae.nextstep.racingcar.step03.validate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-09
 */
@DisplayName("문자열 길이 체크 Test Class")
class StringLengthValidatorTest {

    private final Validator<String> validator = new StringLengthValidator(1, 5);

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("문자열 길이 테스트 - True")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void shouldBeTrueStringLengthTest(String value) {
        boolean valid = validator.isValid(value);
        assertThat(valid).isTrue();
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("문자열 길이 테스트 - False")
    @NullSource
    @ValueSource(strings = {"", "abcdef"})
    void shouldBeFalseStringLengthTest(String value) {
        boolean valid = validator.isValid(value);
        assertThat(valid).isFalse();
    }

}
