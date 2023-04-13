package step3;

import step3.gameobject.RacingGame;
import step3.gameobject.rule.DefaultRaceRule;
import step3.ui.InputView;
import step3.ui.ResultView;

import java.util.List;

public class GameLauncher {

    public static void main(String[] args) {
        List<String> nameList = InputView.getNameOfCars();
        int count = InputView.getCount();
        ResultView.printResultMessage();

        RacingGame racingGame = new RacingGame(nameList, new DefaultRaceRule());
        for (int i = 0; i < count; i++) {
            ResultView.printEachResult(racingGame.race());
        }
        ResultView.printWinner(racingGame.getWinner());
    }

}
