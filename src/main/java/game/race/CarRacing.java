package game.race;

import game.race.model.InputView;
import game.race.support.CarRacingManager;

public class CarRacing {

    public static void main(String[] args) {
        race();
    }

    public static void race() {
        InputView inputView = new InputView();
        inputView.showPrompt();

        CarRacingManager.start(inputView);
    }
}
