package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Score;
import racingcar.domain.Scores;
import racingcar.view.ResultView;

import java.util.Arrays;

@DisplayName("결과 출력 테스트")
public class ResultViewTest {

    @DisplayName("포인트 정보를 전달하면 - 가 출력된다")
    @Test
    void printTest() {
        Scores scores = new Scores();
        scores.addScore(new Score(5));
        Arrays.asList(scores);
        ResultView resultView = new ResultView();
        resultView.printResult(Arrays.asList(scores));

    }
}
