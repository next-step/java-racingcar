package racingcar.ui;

import racingcar.domain.RacingGameResultsBuilder;

public class ResultView {

    public ResultView() {
    }

    public void print(RacingGameResultsBuilder racingGameResultsBuilder) {
        System.out.printf("실행 결과\n%s", racingGameResultsBuilder.getRenderedGameResults());
    }
}
