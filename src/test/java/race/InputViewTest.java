package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;


class InputViewTest {

    @Test
    @DisplayName("inputOutput 테스트")
    void inputOutputTest() {
        //given
        InputStream in = new ByteArrayInputStream("9".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        //then
        assertThat(InputView.inputOutput()).isEqualTo(9);
    }

}