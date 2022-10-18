package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @Test
    @DisplayName("Input Test")
    public void input() {

        String input = "3\n5\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        inputView.scan();

        assertThat(inputView.carCnt()).isEqualTo(3);
        assertThat(inputView.moveCnt()).isEqualTo(5);
    }
}
