package game.race;

import game.race.model.InputView;
import game.race.model.ResultView;
import game.race.support.CarRacingManager;

public class CarRacing {

    public static void main(String[] args) {
        race();
    }

    public static void race() {
        InputView inputView = CarRacingManager.showPrompt();
        ResultView resultView = CarRacingManager.start(inputView);
        CarRacingManager.showResult(resultView);
    }
}
