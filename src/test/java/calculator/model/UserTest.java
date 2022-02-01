package calculator.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.User;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 공백존재() {

        User user = new User();
        String userInput = "1 + 2 *  4 - 1";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        //user.getUserInput();

        assertThatIllegalArgumentException()
            .isThrownBy(user::getUserInput
            );

    }

    void 공백입력() {
        User user = new User();
        String userInput = "";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        //user.getUserInput();

        assertThatIllegalArgumentException()
            .isThrownBy(user::getUserInput
            );
    }
}
