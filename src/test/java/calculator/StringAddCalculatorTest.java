package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringAddCalculatorTest {
    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 빈 문자열이 들어온 경우, 0을 반환한다")
    void splitAndSum_emptyString() {
        //given
        //when
        int result = StringAddCalculator.splitAndSum("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 null이 들어온 경우, 0을 반환한다")
    void splitAndSum_null() {
        //given
        //when
        int result = StringAddCalculator.splitAndSum(null);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 숫자 두개이상이 컴마(,) 구분자로 구분되어 입력된 경우, 숫자들의 합을 반환한다")
    void splitAndSum_NumbersSeparatedByComma() {
        //given
        //when
        int result1 = StringAddCalculator.splitAndSum("1,2");
        int result2 = StringAddCalculator.splitAndSum("1,2,3");
        int result3 = StringAddCalculator.splitAndSum("1,2,3,4");

        //then
        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(6);
        assertThat(result3).isEqualTo(10);
    }

    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 숫자 두개이상이 컴마(,) 또는 콜론(:) 구분자로 구분되어 입력된 경우, 숫자들의 합을 반환한다")
    void splitAndSum_splitAndSum_NumbersSeparatedByCommaOrColon() {
        //given
        //when
        int result1 = StringAddCalculator.splitAndSum("1,2:3");
        int result2 = StringAddCalculator.splitAndSum("1:2");
        int result3 = StringAddCalculator.splitAndSum("1:2,3");
        int result4 = StringAddCalculator.splitAndSum("1:2,3:4");

        //then
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(3);
        assertThat(result3).isEqualTo(6);
        assertThat(result4).isEqualTo(10);
    }

    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 음수가 입력된 경우, RuntimeException 예외가 발생한다")
    void splitAndSum_negative() {
        //given
        //when
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                //then
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Input must be a positive integer");
    }

    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 하나의 숫자가 입력된 경우, 해당 숫자를 반환한다")
    void splitAndSum_number() {
        //given
        //when
        int result1 = StringAddCalculator.splitAndSum("1");
        int result2 = StringAddCalculator.splitAndSum("3");
        int result3 = StringAddCalculator.splitAndSum("10");

        //then
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(3);
        assertThat(result3).isEqualTo(10);
    }

    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 \"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정한 경우, 해당 커스텀 구분자를 기준으로 구분하고 숫자들의 합을 반환한다")
    void splitAndSum_CustomDelimiter() {
        //given
        //when
        int result1 = StringAddCalculator.splitAndSum("//;\n1;2;3");
        int result2 = StringAddCalculator.splitAndSum("//^\n4^10^8");

        //then
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(22);
    }
}
