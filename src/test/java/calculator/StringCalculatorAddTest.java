package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorAddTest {

    @Test
    @DisplayName("null 또는 빈문자열이 입력되면 0을 반환한다. ex:) “” => 0, null=> 0")
    void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나가 입력되면 해당 숫자를 반환한다. ex:) “1” => 1")
    void splitAndSum_숫자하나() {
        int result = StringCalculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개가 입력되면 두개를 합한 숫자가 반환된다. ex:) “1,2” => 3")
    void splitAndSum_쉼표구분자() {
        int result = StringCalculator.splitAndSum("1,2");

        assertThat(result).isEqualTo(3);
    }


    @Test
    @DisplayName(", 또는 : 구분자를 혼합하여 구분자를 사용할 수 있다. ex:) “1,2:3” => 6")
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }


    @Test
    @DisplayName("커스텀 구분자를 사용할 수 있다. ex:) “//;\n1;2;3” => 6")
    void splitAndSum_custom_구분자() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 입력되면 RuntimeException 반환한다 ex:) “-1,2,3” => RuntimeException")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
