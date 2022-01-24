import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import stringCalculator.User;

public class UserTest {

    @Test
    void 공백존재() {

        User user = new User();
        String userInput = "1 + 2 *  4 - 1";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException()
            .isThrownBy(user::getUserInput
            );

    }

    @Test
    void 공백입력() {
        User user = new User();
        String userInput = "";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException()
            .isThrownBy(user::getUserInput
            );
    }

    @Test
    void 입력오류() {
        User user = new User();
        String userInput = "1 1 + 2 + 2 - 3";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException()
            .isThrownBy((user::getUserInput));
    }
}
