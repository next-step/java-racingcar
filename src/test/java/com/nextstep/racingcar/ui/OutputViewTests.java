package com.nextstep.racingcar.ui;

import com.nextstep.racingcar.application.FakeRacingGameResultFactory;
import com.nextstep.racingcar.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTests {
    @DisplayName("우승자를 제외하고 결과를 제대로 보여주는지 확인")
    @Test
    void printResultWithoutWinnerTest() {
        OutputView outputView = new OutputView(FakeRacingGameResultFactory.getFakeRacingGameResult());
        String stringResult = outputView.toStringResult();
        assertThat(stringResult).isEqualTo("poppo : -\n" +
                "ita : -\n" +
                "saul : -\n" +
                "\n" +
                "poppo : --\n" +
                "ita : -\n" +
                "saul : --\n\n");
    }

    @DisplayName("우승자를 제대로 보여주는지 확인")
    @Test
    void printWinnerTest() {
        OutputView outputView = new OutputView(FakeRacingGameResultFactory.getFakeRacingGameResult());
        String stringWinner = outputView.toStringWinner();
        assertThat(stringWinner).isEqualTo("poppo, saul가 최종 우승했습니다.");
    }
}
