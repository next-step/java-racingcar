package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorTest {

    @DisplayName("add calculate() 테스트")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(value = {
            // x, y, expectedResult
            "     1,   4,      5",
            "    13,  21,     34",
            "121942, 591, 122533"
    })
    void calculate1(int x, int y, int expectedResult) {
        int result = Operator.ADD.calculate(x, y);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("subtract calculate() 테스트")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource(value = {
            // x, y, expectedResult
            "     1,   4,     -3",
            "   133,   7,    126",
            "121942, 591, 121351"
    })
    void calculate2(int x, int y, int expectedResult) {
        int result = Operator.SUBTRACT.calculate(x, y);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("multiply calculate() 테스트")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource(value = {
            // x, y, expectedResult
            "   1,   4,      4",
            " 133,   7,    931",
            "1212, 591, 716292"
    })
    void calculate3(int x, int y, int expectedResult) {
        int result = Operator.MULTIPLY.calculate(x, y);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("divide calculate() 테스트")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource(value = {
            // x, y, expectedResult
            "    0,   3,   0",
            "    4,   2,   2",
            "  434,   7,  62",
            "41961, 591,  71"
    })
    void calculate4(int x, int y, int expectedResult) {
        int result = Operator.DIVIDE.calculate(x, y);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("divide calculate() 테스트 : 실패 케이스 -> 나눗셈 시 제수가 0이라면 에러 발생")
    @Test
    void calculate5() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            assertThat(Operator.DIVIDE.calculate(3, 0));
        });
    }


    @DisplayName("build() 테스트 케이스 : 실패 케이스 -> 정의하지 않은 사칙연산 기호인 경우 에러 처리")
    @ParameterizedTest
    @ValueSource(strings = {"&", "%", "@"})
    void build1(String operator) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Operator.build(operator);
        });
    }

    @DisplayName("build() 테스트 케이스 : 성공 케이스 -> + 사칙연산 빌드")
    @Test
    void build2() {
        String operator = "+";

        assertThat(Operator.build(operator)).isEqualTo(Operator.ADD);
    }

    @DisplayName("build() 테스트 케이스 : 성공 케이스 -> - 사칙연산 빌드")
    @Test
    void build3() {
        String operator = "-";

        assertThat(Operator.build(operator)).isEqualTo(Operator.SUBTRACT);
    }

    @DisplayName("build() 테스트 케이스 : 성공 케이스 -> * 사칙연산 빌드")
    @Test
    void build4() {
        String operator = "*";

        assertThat(Operator.build(operator)).isEqualTo(Operator.MULTIPLY);
    }

    @DisplayName("build() 테스트 케이스 : 성공 케이스 -> / 사칙연산 빌드")
    @Test
    void build5() {
        String operator = "/";

        assertThat(Operator.build(operator)).isEqualTo(Operator.DIVIDE);
    }


    @DisplayName("isOperator() 테스트 케이스 : 정의하지 않은 사칙연산의 경우 isOperator() 결과값은 false")
    @ParameterizedTest
    @ValueSource(strings = {"1", "&", "91", ")"})
    void isOperator1(String operator) {
        assertThat(Operator.isOperator(operator)).isFalse();
        assertThat(Operator.isNotOperator(operator)).isTrue();
    }

    @DisplayName("isOperator() 테스트 케이스 : 정의된 사칙연산의 경우 isOperator() 결과값은 true")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperator2(String operator) {
        assertThat(Operator.isOperator(operator)).isTrue();
        assertThat(Operator.isNotOperator(operator)).isFalse();
    }

}
