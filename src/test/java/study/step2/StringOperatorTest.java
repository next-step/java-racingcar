package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringOperatorTest {

    @Test
    @DisplayName("더하기 테스트")
    void 더하기_테스트() {
        StringOperator operator1 = StringOperator.symbol("+");
        assertThat(operator1.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기 테스트")
    void 빼기_테스트() {
        StringOperator operator1 = StringOperator.symbol("-");
        assertThat(operator1.calculate(4, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void 곱하기_테스트() {
        StringOperator operator1 = StringOperator.symbol("*");
        assertThat(operator1.calculate(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나누기 테스트")
    void 나누기_테스트() {
        StringOperator operator1 = StringOperator.symbol("/");
        assertThat(operator1.calculate(4, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("잘못된 연산자 테스트")
    void 잘못된_연산자_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringOperator operator1 = StringOperator.symbol("?");
                }).withMessageContaining("처리할 수 없는 연산자");
    }
}