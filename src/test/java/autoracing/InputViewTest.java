package autoracing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void inputTest() {
        String inputValues = "Mercedes, Ferrari, Lamborghini, McLaren\n4\n";
        InputStream inputStream = new ByteArrayInputStream(inputValues.getBytes());
        InputView input = InputView.takeInput(inputStream);
        assertThat(input.getCarNames()).isEqualTo(Arrays.asList("Mercedes", "Ferrari", "Lamborghini", "McLaren"));
        assertThat(input.getTotalRounds()).isEqualTo(4);
    }
}
