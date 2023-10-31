import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringaddcalculator.StringAddCalculator;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 빈문자열 입력시 0을 반환한다.")
    void splitAndSum_null_또는_빈문자열() {
        int nullResult = StringAddCalculator.splitAndSum(null);
        int emptyResult = StringAddCalculator.splitAndSum("");

        assertThat(nullResult).isEqualTo(emptyResult).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_숫자하나() {
        String inputString = "1";

        int result = StringAddCalculator.splitAndSum(inputString);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력시 두 숫자의 합을 반환한다.")
    void splitAndSum_숫자두개_컴마() {
        String inputString = "1,2";

        int result = StringAddCalculator.splitAndSum(inputString);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 콜론(:) 구분자로 입력시 두 숫자의 합을 반환한다.")
    void splitAndSum_숫자두개_콜론() {
        String inputString = "1:2";

        int result = StringAddCalculator.splitAndSum(inputString);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void splitAndSum_숫자두개이상_구분자두개() {
        String inputString = "1:2,3:4";

        int result = StringAddCalculator.splitAndSum(inputString);

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void splitAndSum_숫자두개이상_커스텀구분자() {
        String inputString = "//;\n1;2;3";

        int result = StringAddCalculator.splitAndSum(inputString);

        assertThat(result).isEqualTo(6);
    }
}
