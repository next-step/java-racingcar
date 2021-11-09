package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    void valid() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            inputView.valid("오", "육");
        }).isInstanceOf(NumberFormatException.class);
    }
}
