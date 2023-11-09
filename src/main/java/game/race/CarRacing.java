package game.race;

import game.race.view.InputView;
import game.race.dto.RaceDto;
import game.race.support.CarRacingManager;

public class CarRacing {

    public static void main(String[] args) {
        race();
    }

    public static void race() {
        InputView inputView = new InputView();
        RaceDto raceDto = inputView.showPrompt();

        CarRacingManager.start(raceDto);
    }
}
