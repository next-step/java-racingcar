package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Score;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;

@DisplayName("결과 출력 테스트")
public class ResultViewTest {

    @DisplayName("포인트 정보를 전달하면 - 가 출력된다")
    @Test
    void printTest() {
        List<Score> scores = Arrays.asList(new Score(4), new Score(5));
        ResultView resultView = new ResultView();
        resultView.printResult(scores);
    }
}
