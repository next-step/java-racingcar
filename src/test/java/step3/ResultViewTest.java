package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    private ResultView resultView;

    @DisplayName("자동차 레이싱 결과를 출력한다.")
    @Test
    void printRacingResult() {

        resultView = new ResultView(Arrays.asList(3, 2, 1));
        resultView.setCarPositions();
        List<String> resultCarPositions = resultView.getResultCarPositions();
        assertThat(resultCarPositions).hasSize(3);
        assertThat(resultCarPositions).containsExactly("---", "--", "-");

    }
}
