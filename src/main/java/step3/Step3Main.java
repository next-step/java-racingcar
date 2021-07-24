package step3;

import java.util.List;
import step3.domain.CarRacingGame;
import step3.domain.GameSetting;
import step3.domain.Round;
import step3.ui.InputView;
import step3.ui.ResultView;

public class Step3Main {

    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        GameSetting gameSetting = inputView.readUserInputForGameSetting();

        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.gameStart(gameSetting);

        List<Round> playedRounds = carRacingGame.getPlayedRounds();
        ResultView resultView = ResultView.getInstance();
        resultView.printAllRoundResult(playedRounds);

    }

}
