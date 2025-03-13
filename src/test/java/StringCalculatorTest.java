import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @DisplayName("숫자 하나를 문자로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void inputOneStringTest() {
        // given
        StringCalculator stringCalculator = new StringCalculator("1");

        // when
        // then
        assertThat(stringCalculator.calc()).isEqualTo(1);
    }

    @DisplayName("빈 문자열은 또는 null은 0을 반환한다.")
    @Test
    void inputBlankTest() {
        assertAll(
                () -> assertThat(new StringCalculator("").calc()).isEqualTo(0),
                () -> assertThat(new StringCalculator(null).calc()).isEqualTo(0));
    }
}
