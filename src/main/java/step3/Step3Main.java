package step3;

import java.util.List;
import step3.domain.CarRacingGame;
import step3.domain.CarRacingGameResult;
import step3.domain.GameSetting;
import step3.runType.NormalRunStrategy;
import step3.ui.InputView;
import step3.ui.ResultView;

public class Step3Main {

    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        List<String> userInputs = inputView.readUserInputs();

        GameSetting gameSetting = new GameSetting(userInputs, new NormalRunStrategy());

        CarRacingGame carRacingGame = new CarRacingGame(gameSetting);
        carRacingGame.gameStart();

        CarRacingGameResult result = carRacingGame.getCarRacingGameResult();
        ResultView resultView = ResultView.getInstance();
        resultView.printAllRoundResult(result);

    }

}
