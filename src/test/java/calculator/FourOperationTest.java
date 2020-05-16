package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class FourOperationTest {

    @ParameterizedTest
    @CsvSource(value = {"+:2", "-:0", "*:1", "/:1"}, delimiter = ':')
    @DisplayName("1, 1로 사칙 연산 결과 비교 테스트")
    void operatorTest(String input, int expected) {
        assertThat(FourOperation.valueOfOperator(input).apply(1, 1)).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산이 아닌 부호 테스트")
    void operatorFaultTest() {
        assertThatIllegalArgumentException().isThrownBy(() ->FourOperation.valueOfOperator("^"));
    }

}