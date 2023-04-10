package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 빈문자orNULL() {
        int actual = StringCalculator.splitAndSum(null);
        assertThat(actual).isEqualTo(0);

        actual = StringCalculator.splitAndSum("");
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 숫자하나() {
        int actual = StringCalculator.splitAndSum("7");
        assertThat(actual).isEqualTo(7);
    }

    @Test
    void 쉼표구분문자열() {
        int actual = StringCalculator.splitAndSum("1,2,3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 콜론구분문자열() {
        int actual = StringCalculator.splitAndSum("1:2:3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 쉼표콜론함께사용() {
        int actual = StringCalculator.splitAndSum("1,2:3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 음수값전달() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("1,-2:3")).isInstanceOf(RuntimeException.class).hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    void 커스텀구분자사용() {
        int acutal = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(acutal).isEqualTo(6);

        acutal = StringCalculator.splitAndSum("//&\n1&2&3");
        assertThat(acutal).isEqualTo(6);
    }
}
