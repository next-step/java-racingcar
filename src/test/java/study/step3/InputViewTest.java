package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    @DisplayName("request() 은 입력 결과를 응답한다.")
    public void request() {
        InputView inputView = new InputView();
        Circuit circuit = inputView.request();
        assertThat(circuit).isNotNull();
    }

    private static class InputView {
        public Circuit request() {
            return new Circuit();
        }
    }

    private static class Circuit {
    }
}
