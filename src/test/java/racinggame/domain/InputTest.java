package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void carNames_정상_입력() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("car1,car2".getBytes());
        System.setIn(inputStream);

        String[] carNames = Input.getCarNames();

        assertThat(carNames[0]).isEqualTo("car1");
        assertThat(carNames[1]).isEqualTo("car2");
    }
}