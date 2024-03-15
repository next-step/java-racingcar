package racing.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.view.InputView.inputPalyersName;

public class InputViewTest {
    @Test
    void 이름_배열_입력() {
        String[] result = inputPalyersName();
        assertThat(result).containsExactly("park", "kim");
    }
}
