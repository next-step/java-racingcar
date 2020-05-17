package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step2 - 연산자 테스트")
class OperatorTest {

    int num1 = 10;
    int num2 = 5;

    @DisplayName("사칙연산 정상수행")
    @ParameterizedTest
    @CsvSource(value = {"+:15","-:5","*:50","/:2"}, delimiter = ':')
    void operator_정상(String testInput, int expected) {
        assertThat(OperatorEnum.of(testInput).calc(num1, num2)).isEqualTo(expected);
    }

    @DisplayName("사칙연산 비정상수행")
    @ParameterizedTest
    @CsvSource(value = {"!:15","@:5","^:50","&:2"}, delimiter = ':')
    void operator_비정상(String testInput, int expected) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            OperatorEnum.of(testInput).calc(num1, num2);
        });
    }
}
