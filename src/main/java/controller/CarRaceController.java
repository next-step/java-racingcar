package controller;

import domain.CarNames;
import domain.CarRaceCount;
import domain.CarRaceGroup;
import domain.CarRaceResult;
import view.InputView;
import view.OutputView;

public class CarRaceController {
    public void run() {
        CarNames carNames = new CarNames(InputView.inputRaceCarName());
        CarRaceCount carRaceCount = new CarRaceCount(InputView.inputCarRaceCount());
        CarRaceGroup carRaceGroup = new CarRaceGroup(carNames);
        CarRaceResult carRaceResult = new CarRaceResult(carRaceGroup);

        OutputView.resultCarRace(carRaceResult.raceResult(carRaceCount));
        OutputView.winner(carRaceResult);
    }
}
