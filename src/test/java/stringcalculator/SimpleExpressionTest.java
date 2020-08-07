package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimpleExpressionTest {

    @DisplayName("정상 동작 :: expression 배열에서 index에 위치하는 인자 가져오기")
    @Test
    void get_success() {
        // given
        SimpleExpression simpleExpression = new SimpleExpression("1 + 2 / 2 * 8");

        // when
        String str = simpleExpression.get(1);

        // then
        assertThat(str).isEqualTo("+");
    }

    @DisplayName("실패 :: expression 배열에서 index에 위치하는 인자 가져올 때 빈 문자열인 경우")
    @Test
    void get_fail() {
        // given
        SimpleExpression simpleExpression = new SimpleExpression("1  2 / 2 * 8");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            simpleExpression.get(1);
        }).withMessageContaining("빈 문자열");
    }

    @DisplayName("정상 동작 :: expression 배열에서 index에 위치하는 숫자 가져오기")
    @Test
    void getInteger_success() {
        // given
        SimpleExpression simpleExpression = new SimpleExpression("1 + 2 / 2 * 8");

        // when
        int integer = simpleExpression.getInteger(0);

        // then
        assertThat(integer).isEqualTo(1);
    }

    @DisplayName("실패 :: 숫자가 아닌 경우")
    @Test
    void getInteger_fail() {
        // given
        SimpleExpression simpleExpression = new SimpleExpression("1  2 / 2 * 8");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            simpleExpression.getInteger(3);
        }).withMessageContaining("정수가 아닙니다.");
    }


}