package carracing;

import carracing.controller.RaceController;

import java.util.List;

public class CarRacing {

    public static void main(String[] args) {
        RaceController raceController = new RaceController();

        List<String> carNames = raceController.getCarNameConsoleInput()
                .getCarNames();
        int roundNumber = raceController.getRoundConsoleInput()
                .getNumber();

        raceController.getRaceResultConsoleOutput(carNames, roundNumber)
                .printRaceRecords();
    }

}
