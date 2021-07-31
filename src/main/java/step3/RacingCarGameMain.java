package step3;

import java.util.List;
import step3.domain.CarRacingGame;
import step3.domain.CarRacingGameResult;
import step3.domain.GameSetting;
import step3.runType.NormalRunStrategy;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingCarGameMain {

    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        List<String> userInputs = inputView.readUserInputs();

        GameSetting gameSetting = new GameSetting(userInputs, new NormalRunStrategy());

        CarRacingGame carRacingGame = new CarRacingGame(gameSetting);
        CarRacingGameResult result = carRacingGame.gameStart();

        ResultView resultView = ResultView.getInstance();
        resultView.printAllRoundResult(result);

    }

}
