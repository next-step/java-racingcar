package racingcar.domain;


import static racingcar.domain.MoveStrategy.*;

import java.util.ArrayList;
import java.util.List;

import java.util.StringJoiner;

import racingcar.view.OutputView;

public class RacingCars {

	Random random = new Random();
	List<Car> cars = new ArrayList<>();
	OutputView output = new OutputView();

	private String[] splitName(String carName, String delimiter) {
		return carName.split(delimiter);
	}


	public RacingCars(String carNames) {
		String[] carNameList = splitName(carNames, ",");
		for (String carName : carNameList) {
			Name name = new Name(carName);
			cars.add(new Car(name, new Position()));

		}
	}

	public void conductCarRacing(int trialNumber) {
		for (int i = 0; i < trialNumber; i++) {
			moveCars();
			output.moveCars(cars);
		}
	}

	private void moveCars() {
		for (Car car : cars) {

			int randomNum = random();
			car.moveStrategy(randomNum);

		}
	}

	public void getWinners() {
		List<Car> winners = new ArrayList<>();

		addToWinnersList(winners);
		viewWinners(winners);
	}

	private void addToWinnersList(List<Car> winners) {
		Position maxPosition = maxPosition(cars);
		for (Car car : cars) {
			if (car.comparePosition(maxPosition))
				winners.add(car);
		}
	}

	public Position maxPosition(List<Car> cars) {
		Position maxPosition = new Position();
		for (Car car : cars) {
			maxPosition = car.max(maxPosition);
		}
		return maxPosition;
	}

	private void viewWinners(List<Car> winners) {
		StringJoiner stringJoiner = new StringJoiner(",");
		for (Car winner : winners) {
			stringJoiner.add(winner.name().toString());
		}
		output.printWinners(stringJoiner);
	}
}
