package autoracing.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void inputTest() {
        String inputValues = "Mercedes, Ferrari, Lamborghini, McLaren\n4\n";
        InputStream inputStream = new ByteArrayInputStream(inputValues.getBytes());
        InputView input = InputView.takeInput(inputStream);
        assertThat(input.getCars()).extracting("name")
                .contains("Mercedes", "Ferrari", "Lamborghini", "McLaren");
        assertThat(input.getTotalRounds()).isEqualTo(4);
    }
}
