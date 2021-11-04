package controller;

import domain.CarCount;
import domain.CarRaceCount;
import domain.CarRaceGroup;
import view.InputView;
import view.OutputView;

public class CarRaceController {
	public void run() {
		CarCount carCount = new CarCount(InputView.inputRaceCarCount());
		CarRaceCount carRaceCount = new CarRaceCount(InputView.inputCarRaceCount());
		CarRaceGroup carRaceGroup = new CarRaceGroup(carCount, carRaceCount);

		OutputView.result(carRaceGroup);
	}
}
