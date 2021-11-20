package carracing;

import carracing.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputViewTest {

    @Test
    @DisplayName("자동차 이름 입력값 검증")
    void isSameCarName() {
        String data = "car";
        InputStream stream = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputView inputView = new InputView();
        inputView.carNameQuestion();
        System.setIn(stream);

        Assertions.assertThat(inputView.getCarNames()).isEqualTo("car");

    }

    @Test
    @DisplayName("시도 횟수 입력값 검증")
    void isSameTryCount() {
        String data = "5";
        InputStream stream = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputView inputView = new InputView();
        inputView.tryCountQuestion();
        System.setIn(stream);

        Assertions.assertThat(inputView.getTryCount()).isEqualTo("5");
    }
}
