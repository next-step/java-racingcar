package controller;

import domain.CarGroup;
import domain.CarRaceCount;
import domain.CarRaceGroup;
import view.InputView;
import view.OutputView;

public class CarRaceController {
    public void run() {
        CarGroup carGroup = new CarGroup(InputView.inputRaceCarName());
        CarRaceCount carRaceCount = new CarRaceCount(InputView.inputCarRaceCount());
        CarRaceGroup carRaceGroup = new CarRaceGroup(carGroup, carRaceCount);

        OutputView.result(carRaceGroup);
        OutputView.winner(carRaceGroup);
    }
}
