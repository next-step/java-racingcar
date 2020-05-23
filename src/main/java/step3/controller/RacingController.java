package step3.controller;

import step3.domain.RacingCar;
import step3.view.RacingInput;
import step3.view.RacingOutput;

import java.util.List;

public class RacingController {

    RacingInput racingInput = new RacingInput();
    RacingOutput RacingOutput = new RacingOutput();

    public String[] inputForStringController() {
        String[] carNames = racingInput.inputForString();

        return carNames;
    }

    public int inputForIntController() {
        int gameCoin = racingInput.inputForInt();

        return gameCoin;
    }

    public void outputCars(List<RacingCar> racingCar) {
        RacingOutput.printRacing(racingCar);
    }

    public void outputWinners(List<String> winnerNames) {
        RacingOutput.printWinner(winnerNames);
    }
}
