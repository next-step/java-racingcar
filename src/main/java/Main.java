import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameRule;
import racingcar.dto.RacingCarGameRequest;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RacingCarGameRule racingCarGameRule = new RacingCarGameRule();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingCarGameRequest userInput = inputView.getUserInput(racingCarGameRule);
        RacingCarGame racingCarGame = new RacingCarGame(racingCarGameRule,userInput);
        while(!racingCarGame.isDone()) {
            racingCarGame.play();
        }
        resultView.printFinalResult(racingCarGame.getFinalScoreBoard());
    }
}
