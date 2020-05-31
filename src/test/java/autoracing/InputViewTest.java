package autoracing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void inputTest() {
        String inputValues = "3\n4\n";
        InputStream inputStream = new ByteArrayInputStream(inputValues.getBytes());
        InputView input = InputView.takeInput(inputStream);
        assertThat(input.getNumberOfCars()).isEqualTo(3);
        assertThat(input.getTotalRounds()).isEqualTo(4);
    }
}
