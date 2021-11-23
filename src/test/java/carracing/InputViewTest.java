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
        String carName = inputView.carNameQuestion();
        System.setIn(stream);

        Assertions.assertThat(carName).isEqualTo("car");

    }

    @Test
    @DisplayName("시도 횟수 입력값 검증")
    void isSameTryCount() {
        String data = "5";
        InputStream stream = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputView inputView = new InputView();
        String tryCount = inputView.tryCountQuestion();
        System.setIn(stream);

        Assertions.assertThat(tryCount).isEqualTo("5");
    }
}
