package step2;

import error.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitAddCalculatorTest {

    @Nested
    @DisplayName("입력하는 값이")
    class blank_or_null_value {
        @Test
        @DisplayName("빈 문자열이면, 0 을 반환한다")
        void blank_value() {
            Assertions.assertThat(SplitAddCalculator.calculate("")).isZero();
        }

        @Test
        @DisplayName("null 값이면, 0 을 반환한다")
        void null_value() {
            Assertions.assertThat(SplitAddCalculator.calculate(null)).isZero();
        }
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력하면, 해당 숫자를 반환한다")
    void 문자_하나() {
        Assertions.assertThat(SplitAddCalculator.calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력하면, 두 숫자의 합을 반환한다")
    void 컴마_구분자() {
        Assertions.assertThat(SplitAddCalculator.calculate(("1,2"))).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    void 콜론_구분자() {
        Assertions.assertThat(SplitAddCalculator.calculate(("1:2"))).isEqualTo(3);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void 커스텀_구분자() {
        Assertions.assertThat(SplitAddCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void 음수시_예외처리() {
        assertThatThrownBy(() -> SplitAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.ERR_NUMBER_RANGE_MESSAGE.print());
    }

    @Test
    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하면, RuntimeException 예외를 반환한다.")
    void 문자열_예외처리() {
        assertThatThrownBy(() -> SplitAddCalculator.calculate("k,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.ERR_NUMBER_FORMAT_MESSAGE.print());
    }
}