package calculator.domain;

import com.ginsberg.junit.exit.ExpectSystemExit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class InputTest {

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
