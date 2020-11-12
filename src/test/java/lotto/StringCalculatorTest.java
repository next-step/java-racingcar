package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setup() {
        this.stringCalculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
    @Test
    public void test() {
        Integer result1 = this.stringCalculator.enterExpression(null);
        Integer result2 = this.stringCalculator.enterExpression("");

        assertAll(
                () -> assertThat(result1).isEqualTo(0),
                () -> assertThat(result2).isEqualTo(0)
        );
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"
    })
    public void test1(String value) {
        Integer result = this.stringCalculator.enterExpression(value);
        assertThat(result).isEqualTo(value);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2:3",
            "3,4:7",
            "6,9:15",
            "20,13:33",
            "24,12:36",
            "123,234:357",
    },
            delimiter = ':'
    )
    public void test2(String expression, Integer expected) {
        Integer result = this.stringCalculator.enterExpression(expression);
        assertThat(result).isEqualTo(expected);
    }
}
