package step3.view;

import step3.model.RacingCarGame;
import step3.model.RandomMovingStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

    @Test
    @DisplayName("자동차 경주 결과 출력 테스트")
    void printRoundResultTest() {
        RacingCarGame racingCarGame = new RacingCarGame(3);

        for (int i = 0; i < 5; i++) {
            racingCarGame.play(new RandomMovingStrategy());
            ResultView.getRoundResult(racingCarGame.getCars(), "-");
        }
    }
}
