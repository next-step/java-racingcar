package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateOutViewTest {
    @Test
    @DisplayName("출력 메시지")
    void outViewMessage() {
        CalculateOutView.showResult(3);
    }
}
