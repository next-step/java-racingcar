package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.util.RacingCarUtil;
import racingCar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @Test
    @DisplayName("[TEST] inputView.scan()")
    public void scanTest() {

        String input = "3\n5\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        inputView.scan();

        assertThat(inputView.carCnt()).isEqualTo(3);
        assertThat(inputView.moveCnt()).isEqualTo(5);
    }

    @Test
    @DisplayName("[TEST] inputView.scanWithNames()")
    public void scanWithNamesTest() {

        String input = "pobi,crong,honux\n5\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        inputView.scanWithNames();
        String[] carNames = RacingCarUtil.inputNameToCarNames(inputView.carNames());
        inputView.severalCars(carNames.length);

        assertThat(inputView.carCnt()).isEqualTo(3);
        assertThat(inputView.moveCnt()).isEqualTo(5);
    }
}
