package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class CliInputViewTest {

    @Test
    @DisplayName("차 수 입력 기능")
    void getNumberOfCarFromCliInput() {
        String data = "3";
        InputStream stdin = System.in;
        System.setIn(
                new ByteArrayInputStream(data.getBytes()));

        int numberOfCar = CliInputView.getNumberOfCarFromCliInput();

        assertThat(numberOfCar).isEqualTo(3);

        System.setIn(stdin);
    }
}
