package step3;

import step3.domain.CarRacingGame;
import step3.domain.GameSetting;
import step3.ui.InputView;

public class Step3Main {

    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        GameSetting gameSetting = inputView.readUserInputForGameSetting();

        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.gameStart(gameSetting);

    }

}
