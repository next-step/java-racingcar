package stringaddcalculator.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {" :true", ":true"}, delimiter = ':')
    @DisplayName("Null 또는 공백을 입력시 True를 반환한다.")
    void stringValidator_null_또는_공백(String inputString, boolean expected) {
        assertThat(StringValidator.isNullOrEmptyString(inputString)).isEqualTo(expected);
    }

    @Test
    @DisplayName("한글자만 입력했을 경우 True를 반화한다.")
    void stringValidator_한글자() {
        String inputString = "엄";

        boolean result = StringValidator.isOneCharacterString(inputString);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("두글자이상 입력했을 경우 모든 메소드에 대해 False를 반환한다.")
    void stringValidator_두글자() {
        String inputString = "엄태";

        boolean nullOrEmptyResult = StringValidator.isNullOrEmptyString(inputString);
        boolean oneCharacterResult = StringValidator.isOneCharacterString(inputString);

        assertThat(nullOrEmptyResult).isEqualTo(oneCharacterResult).isFalse();
    }

}