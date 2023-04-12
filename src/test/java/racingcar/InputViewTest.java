package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    @Test
    @DisplayName("자동차 대수 입력")
    void numberOfCars() {
        String numberOfCars = "3";

        InputStream in = new ByteArrayInputStream(numberOfCars.getBytes());
        System.setIn(in);

        assertThat(InputView.registerNumberOfCars()).isEqualTo(Integer.parseInt(numberOfCars));
    }

    @Test
    @DisplayName("시도할 횟수 입력")
    void numberOfMovements() {
        String numberOfCars = "5";

        InputStream in = new ByteArrayInputStream(numberOfCars.getBytes());
        System.setIn(in);

        assertThat(InputView.registerNumberOfMovements()).isEqualTo(Integer.parseInt(numberOfCars));
    }
}
