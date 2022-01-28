package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.assertj.core.api.ThrowableAssertAlternative;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import stringCalculator.Calculator;
import stringCalculator.User;
import stringCalculator.UserInputValue;

public class UserTest {

    @Test
    void 문자열에_공백이_포함되면_예외가_발생한다() {
        User user = new User();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> user.getUserInput(Arrays.asList("1", "+", "2", "*", " ", "4")));
    }

    @Test
    void 아무것도_입력하지_않으면_예외가_발생한다() {
        User user = new User();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> user.getUserInput(Arrays.asList("")));
    }

    @Test
    void 연산자_자리에_숫자를_입력하면_얘외가_발생한다() {
        User user = new User();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> user.getUserInput(Arrays.asList("1", "1", "+", "2", "+", "2", "-", "3")));
    }

    @Test
    void 숫자_자리에_연산자를_입력하면_예외가_발생한다() {
        User user = new User();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> user.getUserInput(Arrays.asList( "1", "+", "*", "+", "2", "-", "3")));
    }
}
