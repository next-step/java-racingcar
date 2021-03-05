import racingcar.domain.RacingCarGame;
import racingcar.dto.RacingCarGameRequest;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingCarGameRequest userInput = inputView.getUserInput();
        RacingCarGame racingCarGame = new RacingCarGame(userInput);
        while(!racingCarGame.isDone()) {
            racingCarGame.play();
        }
        resultView.printFinalResult(racingCarGame.getFinalScoreBoard());
    }
}
