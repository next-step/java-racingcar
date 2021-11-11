package controller;

import domain.CarNames;
import domain.CarRaceCount;
import domain.CarRaceGroup;
import view.InputView;
import view.OutputView;

public class CarRaceController {
    public void run() {
        CarNames carNames = new CarNames(InputView.inputRaceCarName());
        CarRaceCount carRaceCount = new CarRaceCount(InputView.inputCarRaceCount());
        CarRaceGroup carRaceGroup = new CarRaceGroup(carNames);

        OutputView.resultCarRace(carRaceGroup, carRaceCount);
        OutputView.winner(carRaceGroup);
    }
}
