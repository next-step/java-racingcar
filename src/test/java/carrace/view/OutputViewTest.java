package carrace.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @DisplayName("포지션 숫자에 따라 포지션이 정확히 출력되어야합니다.")
    @Test
    public void calculateLatestPosition_ValidPosition() {
        OutputView outputView = new OutputView();
        String expected = "----";
        String actual = outputView.calculateLatestPosition(4);

        assertThat(actual).isEqualTo(expected);
    }
}
