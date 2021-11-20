package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class CarRaceController {
    public void run() {
        CarNames carNames = new CarNames(InputView.inputRaceCarName());
        CarRaceCount carRaceCount = new CarRaceCount(InputView.inputCarRaceCount());
        CarRaceGroup carRaceGroup = new CarRaceGroup(carNames);
        CarRaceResult carRaceResult = new CarRaceResult(carRaceGroup);

        OutputView.resultCarRace(carRaceResult, carRaceCount);
        OutputView.winner(new Winner(carRaceGroup));
    }
}
