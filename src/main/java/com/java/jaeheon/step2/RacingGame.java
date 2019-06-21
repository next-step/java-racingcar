package com.java.jaeheon.step2;

import com.java.jaeheon.step2.controller.CarRaceController;
import com.java.jaeheon.step2.model.CarManagement;
import com.java.jaeheon.step2.model.CarRacing;
import com.java.jaeheon.step2.view.InputView;

public class RacingGame {

	public static void main(String[] args) {

		String nameOfCars = InputView.inputViewNameOfCars();
		int numberOfAttempts = InputView.inputViewNumberOfAttempts();

		CarRaceController carRaceController = new CarRaceController();
		carRaceController.carRegister(nameOfCars);
		carRaceController.carRacingReady(numberOfAttempts);
		carRaceController.carRacingStart();
		carRaceController.resultViewer();
	}
}
