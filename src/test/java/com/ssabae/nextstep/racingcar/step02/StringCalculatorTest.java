package com.ssabae.nextstep.racingcar.step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-02
 */
@DisplayName("계산기 테스트 클래스")
class StringCalculatorTest {

    private final StringCalculateValidator validator = new StringCalculateValidator();
    private final StringCalculator stringCalculator = new StringCalculator(validator);

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("계산기 계산 테스트")
    @ValueSource(strings = {"2 + 3 * 4 / 2", "-2 + 3 * 20 / 2"})
    void calculateTest(String value) {
        int calculate = stringCalculator.calculate(value);
        assertThat(calculate).isEqualTo(10);
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("계산기 허용되지 않는 문자열 테스트")
    @ValueSource(strings = {"2 + 3 * 4 /", "", " ", "1 ! 2", "1 ! 2"})
    void calculateInvalidInputTest(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(value));
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("문자 공백 검사")
    @NullSource
    @ValueSource(strings = {" ", "", "    "})
    void isEmptyTest(String str) {
        boolean isBlank = stringCalculator.isBlank(str);
        assertThat(isBlank).isTrue();
    }

    @Test
    @DisplayName("계산기 연산 처리 로직 테스트")
    void operationTest() {
        assertThat(Operator.PLUS.operation(1, 2)).isEqualTo(3);
        assertThat(Operator.MINUS.operation(5, 2)).isEqualTo(3);
        assertThat(Operator.TIMES.operation(2, 2)).isEqualTo(4);
        assertThat(Operator.DIVIDE.operation(4, 4)).isEqualTo(1);
    }
}
