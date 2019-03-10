package racingcar;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    public void inputCarCountTest() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(this.inputView.inputCarCount()).isEqualTo(10);
    }

    @Test
    public void inputTryCountTest() {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(this.inputView.inputTryCount()).isEqualTo(0);
    }
}