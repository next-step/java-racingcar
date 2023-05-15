package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 빈문자")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isZero();

        result = StringAddCalculator.splitAndSum("      ");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("숫자 하나")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자 하나만")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표, 콜론 구분자 함께")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자만")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 포함한 모든 구분자 함께")
    // 이 케이스가 테스트 코드에서는 성공하는데, 메인 클래스에서 직접 입력했을때는 성공하지 않아서 궁금합니다ㅠㅠ
    public void splitAndSum_all_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3,4:5,6");
        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("음수 입력")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력")
    public void splitAndSum_not_number() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,2,three")).isInstanceOf(NumberFormatException.class);
    }

}
