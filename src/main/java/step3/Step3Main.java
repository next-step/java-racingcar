package step3;

import step3.domain.CarRacingGame;
import step3.domain.GameSetting;
import step3.ui.InputView;

public class Step3Main {

    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();

        GameSetting gameSetting = inputView.readUserInputForGameSetting();

        playGame(gameSetting);

    }

    private static void playGame(GameSetting gameSetting) {
        int carCount = gameSetting.getCarCount();
        int roundCount = gameSetting.getRoundCount();

        CarRacingGame racingGame = CarRacingGame.createRacingGameWithCarCount(carCount);

        racingGame.gameStart(roundCount);
    }

}
