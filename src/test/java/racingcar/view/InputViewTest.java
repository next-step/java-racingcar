package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    @Test
    @DisplayName("자동차 이름 입력")
    void nameOfCars() {
        String nameOfCars = "pobi,crong,honux";

        InputStream in = new ByteArrayInputStream(nameOfCars.getBytes());
        System.setIn(in);

        assertThat(InputView.inputNameOfCars()).isEqualTo(nameOfCars);
    }

    @Test
    @DisplayName("시도할 횟수 입력")
    void numberOfMovements() {
        String numberOfCars = "5";

        InputStream in = new ByteArrayInputStream(numberOfCars.getBytes());
        System.setIn(in);

        assertThat(InputView.inputNumberOfMovements()).isEqualTo(Integer.parseInt(numberOfCars));
    }
}
