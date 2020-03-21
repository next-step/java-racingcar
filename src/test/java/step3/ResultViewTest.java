package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    private ResultView resultView;

    @DisplayName("자동차 레이싱 결과를 출력한다.")
    @Test
    void printRacingResult() {
        int[] result = { 3, 2, 1 };
        resultView = new ResultView(result);
        resultView.setCarPositions();
        String[] resultCarPositions = resultView.getResultCarPositions();
        assertThat(resultCarPositions).hasSize(result.length);
        assertThat(resultCarPositions).containsExactly("---", "--", "-");

    }
}
