package racingcar.ui;

import racingcar.domain.RacingGameResults;

public class ResultView {

    public ResultView() {
    }

    public void print(RacingGameResults racingGameResults) {
        System.out.printf("실행 결과\n%s", racingGameResults.getRenderedGameResults());
    }
}
