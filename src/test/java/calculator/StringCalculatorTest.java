package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("null과 빈 문자열은 0으로 취급한다")
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = stringCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = stringCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자가 하나일 때 그 숫자를 출력한다")
    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표로 구분된 숫자들을 모두 더한다")
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표, 콜론으로 구분된 숫자들을 모두 더한다")
    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자로 구분된 숫자들을 모두 더한다")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수는 예외를 던진다")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
