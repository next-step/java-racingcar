package step2.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperatorTest {

    @DisplayName("사칙연산 기호가 아닌 기호를 발견하면 IllegalArgumentException 발생")
    @Test
    void throwIllegalArgumentExceptionWhenGivenNonValidOperator() {
        String givenOperator = "&";
        assertThrows(IllegalArgumentException.class,()->Operator.get(givenOperator));
    }

    @DisplayName("주어진 Operator에 따른 연산 실행")
    @ParameterizedTest
    @CsvSource(value = {"+:7", "-:1", "*:12", "/:1"}, delimiter = ':')
    void add(String operator, int expectedResult) {
        int givenOne = 4;
        int givenTheOther = 3;
        assertThat(Operator.get(operator).compute(givenOne, givenTheOther)).isEqualTo(expectedResult);
    }

    @DisplayName("0으로 나누면 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource(value = {"5:0"}, delimiter = ':')
    void throwIllegalArgumentExceptionWhenDividingZero(Integer one, Integer theOther) {
        String givenOperator = "/";

        assertThrows(IllegalArgumentException.class,()->Operator.get(givenOperator).compute(one, theOther));
    }

}
