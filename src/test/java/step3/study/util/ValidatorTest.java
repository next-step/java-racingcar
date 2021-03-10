package step3.study.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a","b","c"})
    void numberCheck(String str) {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    Validator.numberCheck(str);
                }).withMessage("숫자형식이 아닙니다.");
    }
}