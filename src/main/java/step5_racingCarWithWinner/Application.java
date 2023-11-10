package step5_racingCarWithWinner;

import step5_racingCarWithWinner.domain.Car;
import step5_racingCarWithWinner.domain.RacingGame;
import step5_racingCarWithWinner.domain.Response;
import step5_racingCarWithWinner.view.RacingGameResultView;
import step5_racingCarWithWinner.view.InputView;

import java.util.List;

public class Application {

    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_NAME_QUESTION = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {

        String[] carNames = InputView.stringsSplitByComma(CAR_NAME_QUESTION);
        int gameCount = InputView.intInput(GAME_NAME_QUESTION);

        Response result = new RacingGame(carNames, gameCount).play();

        new RacingGameResultView().printResult(result);
    }
}
