package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    @DisplayName("숫자포멧에러")
    void valid() {
        assertThatThrownBy(() -> {
            new InputView("오", "육");
        }).isInstanceOf(NumberFormatException.class);
    }
}
