package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringExpressionTest {

    @DisplayName(" 입력 문자열을 공백을 기준으로 나눈다.")
    @Test
    void split_by_space() {
        StringExpression expression = new StringExpression("1 + 3");
        String[] result = expression.split();

        assertThat(result).contains("1", "+", "3").hasSize(3);
    }

    @DisplayName("입력 문자열에 숫자와 사칙연산 연산자를 제외한 값이 있을 경우 에러 처리")
    @Test
    void illegalArgumentException_test() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new StringExpression("1 + 3 / 2 A 1");
                }).withMessage("입력 문자열은 빈 공백 문자열로 구분된 숫자와 사칙 연산자 여야 합니다.");
    }
}