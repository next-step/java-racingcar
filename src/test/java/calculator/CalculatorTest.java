package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.getSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CalculatorTest {
    @DisplayName("null 또는 빈 문자열 일시 0을 반환한다")
    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = getSum(null);
        assertThat(result).isZero();

        result = getSum("");
        assertThat(result).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void splitAndSum_숫자하나() {
        int result = getSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @Test
    void splitAndSum_쉼표구분자() {
        int result = getSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = getSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void splitAndSum_custom_구분자() {
        int result = getSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("//와 \\n 문자 만 존재하면 0을 반환한다.")
    @Test
    public void custom_구분자_only() {
        int result = getSum("//;\n");
        assertThat(result).isZero();
    }


    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> getSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }


}
