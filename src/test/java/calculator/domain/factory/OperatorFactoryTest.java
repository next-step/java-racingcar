package calculator.domain.factory;

import calculator.domain.AddOperator;
import calculator.domain.DivideOperator;
import calculator.domain.MultiplyOperator;
import calculator.domain.SubtractOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorFactoryTest {

    @DisplayName("build() 테스트 케이스 : 실패 케이스 -> 정의하지 않은 사칙연산 기호인 경우 에러 처리")
    @ParameterizedTest
    @ValueSource(strings = {"&", "%", "@"})
    void build1(String operator) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            OperatorFactory.build(operator);
        });
    }

    @DisplayName("build() 테스트 케이스 : 성공 케이스 -> + 사칙연산 빌드")
    @Test
    void build2() {
        String operator = "+";

        assertThat(OperatorFactory.build(operator))
                .isExactlyInstanceOf(AddOperator.class);
    }

    @DisplayName("build() 테스트 케이스 : 성공 케이스 -> - 사칙연산 빌드")
    @Test
    void build3() {
        String operator = "-";

        assertThat(OperatorFactory.build(operator))
                .isExactlyInstanceOf(SubtractOperator.class);
    }

    @DisplayName("build() 테스트 케이스 : 성공 케이스 -> * 사칙연산 빌드")
    @Test
    void build4() {
        String operator = "*";

        assertThat(OperatorFactory.build(operator))
                .isExactlyInstanceOf(MultiplyOperator.class);
    }

    @DisplayName("build() 테스트 케이스 : 성공 케이스 -> / 사칙연산 빌드")
    @Test
    void build5() {
        String operator = "/";

        assertThat(OperatorFactory.build(operator))
                .isExactlyInstanceOf(DivideOperator.class);
    }

    @DisplayName("isOperator() 테스트 케이스 : 정의하지 않은 사칙연산의 경우 isOperator() 결과값은 false")
    @ParameterizedTest
    @ValueSource(strings = {"1", "&", "91", ")"})
    void isOperator1(String operator) {
        assertThat(OperatorFactory.isOperator(operator)).isFalse();
        assertThat(OperatorFactory.isNotOperator(operator)).isTrue();
    }

    @DisplayName("isOperator() 테스트 케이스 : 정의된 사칙연산의 경우 isOperator() 결과값은 true")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperator2(String operator) {
        assertThat(OperatorFactory.isOperator(operator)).isTrue();
        assertThat(OperatorFactory.isNotOperator(operator)).isFalse();
    }
}
