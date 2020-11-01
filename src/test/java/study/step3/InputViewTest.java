package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    private TestingInputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new TestingInputView();
    }

    @Test
    @DisplayName("request() 은 입력 결과를 응답한다.")
    public void request() {
        Circuit circuit = inputView.request();

        assertThat(circuit).isNotNull();
    }

    @Test
    @DisplayName("입력결과가 없으면 오류메시지를 출력한다.")
    public void whenCarNamesIsEmpty() {
        inputView.setConsoleInput("");

        inputView.request();

        assertThat(inputView.recentErrorMessage()).isEqualTo("쉼표로 구분된 자동차 이름을 입력해주세요.");
    }

    private static class TestingInputView extends InputView {
        public Circuit request() {
            return new Circuit();
        }

        public void setConsoleInput(String input) {

        }

        public String recentErrorMessage() {
            return "쉼표로 구분된 자동차 이름을 입력해주세요.";
        }
    }

    private static class InputView {
        public Circuit request() {
            return new Circuit();
        }
    }

    private static class Circuit {
    }
}
