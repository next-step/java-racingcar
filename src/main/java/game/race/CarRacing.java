package game.race;

import java.util.List;

import game.race.view.InputView;
import game.race.dto.RaceDto;
import game.race.support.CarRacingManager;
import game.race.view.ResultView;

public class CarRacing {

    public static void main(String[] args) {
        race();
    }

    public static void race() {
        RaceDto raceDto = InputView.showPrompt();

        CarRacingManager manager = new CarRacingManager();
        List<String> winner = manager.start(raceDto);

        ResultView.printWinners(winner);
    }
}
