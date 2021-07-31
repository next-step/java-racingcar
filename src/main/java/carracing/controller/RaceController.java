package carracing.controller;

import carracing.domain.CarNames;
import carracing.domain.RaceManager;
import carracing.domain.RaceResult;
import carracing.domain.RoundNumber;
import carracing.view.CarNameConsoleInput;
import carracing.view.RaceResultConsoleOutput;
import carracing.view.RoundConsoleInput;

import java.util.List;

public class RaceController {

    public CarNameConsoleInput getCarNameConsoleInput() {
        return new CarNameConsoleInput();
    }

    public RoundConsoleInput getRoundConsoleInput() {
        return new RoundConsoleInput();
    }

    public RaceResultConsoleOutput getRaceResultConsoleOutput(List<String> carNames, int roundNumber) {
        return new RaceResultConsoleOutput(getRaceResult(carNames, roundNumber));
    }

    private RaceResult getRaceResult(List<String> carNames, int roundNumber) {
        return new RaceManager().play(new CarNames(carNames), new RoundNumber(roundNumber));
    }

}
