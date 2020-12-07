package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultViewTest {

    @Test
    @DisplayName("자동차 상태를 출력하는 기능")
    void print() {
        RacingGame racingGame = new RacingGame(3, 5);
        ResultView resultView = new ResultView(racingGame);
        resultView.print();
    }

}
