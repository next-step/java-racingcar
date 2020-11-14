package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
        assertThat(result).isEqualTo(Integer.parseInt(value));
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2-3",
            "3,4-7",
            "6,9-15",
            "20,13-33",
            "24,12-36",
            "123,234-357",
    },
            delimiter = '-'
    )
    public void test2(String expression, Integer expected) {
        Integer result = this.stringCalculator.enterExpression(expression);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2-3",
            "3:4-7",
            "6,9-15",
            "20:13-33",
            "24,12-36",
            "123:234-357",
    },
            delimiter = '-'
    )
    public void test3(String expression, Integer expected) {
        Integer result = this.stringCalculator.enterExpression(expression);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. 커스텀 구분자를 사용 가능하다.")
    @Test
    public void test4() {
        Integer result = this.stringCalculator.enterExpression("//;\n7;13");
        assertThat(result).isEqualTo(20);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "-1,2,3"
    })
    public void test5(String expression, Integer expected) {
        assertThatThrownBy(
                () -> this.stringCalculator.enterExpression(expression)
        ).isInstanceOf(RuntimeException.class);
    }
}
