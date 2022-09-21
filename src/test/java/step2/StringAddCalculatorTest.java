package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("요구사항 1: 주어진 문자열이 null 이거나 빈문자이면 0 반환")
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("요구사항 2: 주어진 문자열이 숫자 하나 그 자체이면 해당 숫자를 반환")
    void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 3: 주어진 문자열이 쉼표를 구분자로 가진다면 쉼표로 구분된 숫자들의 합을 반환")
    void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 4: 주어진 문자열이 쉼표 혹은 콜론을 구분자로 가진다면 쉼표와 콜론으로 구분된 숫자들의 합을 반환")
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("요구사항 5: “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정한 문자열이면 커스텀 구분자로 구분된 숫자들의 합을 반환")
    void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("요구사항 6: 주어진 문자열을 구분자로 나눴을 때 음수가 포함되어 있다면 RuntimeException 발생")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("요구사항 6*: 주어진 문자열을 구분자로 나눴을 때 숫자가 아닌 문자가 포함되어 있다면 RuntimeException 발생")
    void splitAndSum_숫자가_아닌값_포함() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,a,3"))
                .isInstanceOf(RuntimeException.class);
    }

}