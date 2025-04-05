package carrace.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OutputViewTest {

    @DisplayName("우승자 문자열이 빈 문자열이여서는 안됩니다.")
    @Test
    public void printWinner_NoWinner() {
        OutputView outputView = new OutputView();
        List<String> inputWinner = List.of();

        assertThatThrownBy(() -> outputView.printWinner(inputWinner))
                .isInstanceOf(RuntimeException.class);
    }
}
