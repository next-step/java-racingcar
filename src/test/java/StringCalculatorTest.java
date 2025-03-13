import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @DisplayName("숫자 하나를 문자로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void InputOneStringTest() {
        // given
        StringCalculator stringCalculator = new StringCalculator("1");

        // when
        // then
        assertThat(stringCalculator.calc()).isEqualTo(1);
    }
}
