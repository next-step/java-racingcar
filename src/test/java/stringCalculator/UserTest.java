package stringCalculator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void 빈문자열만_입력하면_예외가_발생한다() {
        UserInputValue user = new UserInputValue();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> user.validateBlankCarName(Arrays.asList("")));
    }

    @Test
    void 연산자_자리에_숫자를_입력하면_얘외가_발생한다() {
        UserInputValue user = new UserInputValue();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> user.validateEmptyNumber(Arrays.asList("1", "+", "-", "+", "2", "-", "3")));
    }

    @Test
    void 숫자_자리에_연산자를_입력하면_예외가_발생한다() {
        UserInputValue user = new UserInputValue();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> user.validateEmptyOperation(Arrays.asList( "1", "+", "9", "0", "2", "-", "3")));
    }
}
