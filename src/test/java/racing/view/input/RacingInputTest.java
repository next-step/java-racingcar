package racing.view.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingInputTest {
    @Test
    void inputNameTest() {
        //given
        String names = "pobi,crong,honux";
        InputStream inputStream = new ByteArrayInputStream(names.getBytes(StandardCharsets.UTF_8));
        RacingInput racingInput = new RacingInput(inputStream);

        //when
        List<String> carNames = racingInput.inputName();

        //then
        assertThat(carNames).hasSize(3);
        assertThat(carNames.get(0)).isEqualTo("pobi");
        assertThat(carNames.get(1)).isEqualTo("crong");
        assertThat(carNames.get(2)).isEqualTo("honux");
    }

    @Test
    void inputCountTest() {
        //given
        String count = "5";
        InputStream inputStream = new ByteArrayInputStream(count.getBytes(StandardCharsets.UTF_8));
        RacingInput racingInput = new RacingInput(inputStream);

        //when
        int result = racingInput.inputCount();

        //then
        assertThat(result).isEqualTo(5);
    }
}
