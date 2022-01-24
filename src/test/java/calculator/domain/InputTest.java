package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ginsberg.junit.exit.ExpectSystemExit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @ValueSource(strings = {"", " ", "    "})
    @ParameterizedTest
    void checkIsBlank_입력으로_공백이_들어옴(String blank) {

        // then
        assertThrows(IllegalArgumentException.class, () -> Validator.checkIsBlack(blank));
    }

    @Test
    void checkIsBlank_공백이_아님() {

        // then
        assertDoesNotThrow(() -> Validator.checkIsBlack("1 + 2"));
    }

    @ExpectSystemExit
    @Test
    void q를_입력하면_종료된다() throws IOException {

        // given
        InputStream inputStream = new ByteArrayInputStream("q".getBytes());
        System.setIn(inputStream);

        // then
        Input.getUserInput();
    }
}
