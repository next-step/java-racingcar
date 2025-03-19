package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 음수는_RuntimeException을_발생시킨다() {
        assertThatThrownBy(() -> calculate("-1,2,3")).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자_또는_null은_0을_반환한다(String input) {
        assertThat(calculate(input)).isEqualTo(0);
    }

    @Test
    void 커스텀_구분자_정상_동작한다() {
        assertThat(calculate("//&\n1&2")).isEqualTo(3);
    }

    @Test
    void 컴마_콜론_구분자_정상_동작한다() {
        assertThat(calculate("1:2,3")).isEqualTo(6);
    }

    @Test
    void 콜론_구분자_정상_동작한다() {
        assertThat(calculate("1:2")).isEqualTo(3);
    }

    @Test
    void 컴마_구분자_정상_동작한다() {
        assertThat(calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 구분자_없어도_정상_동작한다() {
        assertThat(calculate("1")).isEqualTo(1);
    }

}
