import static org.assertj.core.api.Assertions.assertThat;
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
    void 공백존재() {

        User user = new User();

        assertThatIllegalArgumentException()
            .isThrownBy(
                (ThrowingCallable) user.getUserInput(Arrays.asList("1", "+", "2", "*", " ", "4")));
    }

    @Test
    void 공백입력() {
        User user = new User();

        assertThatIllegalArgumentException()
            .isThrownBy(
                (ThrowingCallable) user.getUserInput(Arrays.asList("")));
    }

    @Test
    void 입력오류() {
        User user = new User();

        assertThatIllegalArgumentException()
            .isThrownBy(
                (ThrowingCallable) user.getUserInput(
                    Arrays.asList("1", "1", "+", "2", "+", "2", "-", "3")));
    }
}
