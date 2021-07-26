package carracing;

import carracing.controller.RaceController;
import carracing.domain.RaceResult;
import carracing.service.RaceService;
import carracing.view.CarNameConsoleInput;
import carracing.view.RoundConsoleInput;
import carracing.view.RaceResultConsoleOutput;

import java.util.List;

public class CarRacing {

    public static void main(String[] args) {
        CarNameConsoleInput carNameConsoleInput = new CarNameConsoleInput();
        RoundConsoleInput roundConsoleInput = new RoundConsoleInput();
        RaceController raceController = new RaceController(new RaceService());
        RaceResultConsoleOutput raceResultConsoleOutput = new RaceResultConsoleOutput();

        List<String> carNames = carNameConsoleInput.getCarNames();
        int roundNumber = roundConsoleInput.getNumber();
        RaceResult raceResult = raceController.play(carNames, roundNumber);
        raceResultConsoleOutput.printRaceRecords(raceResult);
    }

}
