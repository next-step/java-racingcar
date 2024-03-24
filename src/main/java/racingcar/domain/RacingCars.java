package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

import racingcar.view.OutputView;

public class RacingCars {
	Random random = new Random();
	List<Car> cars = new ArrayList<>();
	OutputView output = new OutputView();

	private String[] splitName(String carName, String delimiter) {
		return carName.split(delimiter);
	}

	public RacingCars(String carNames){
		String[] carNameList = splitName(carNames, ",");
		for (String carName : carNameList) {
			cars.add(new Car(carName));
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
			int randomNum = random.nextInt(10);
			car.moveForward(randomNum);
		}
	}

	public void getWinners() {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			addToWinnersList(winners, car);
		}
		viewWinners(winners);
	}

	private void addToWinnersList(List<Car> winners, Car car) {
		int maxPosition = car.maxPosition(winners);
		if (car.comparePosition(maxPosition)) winners.add(car);
	}

	private void viewWinners(List<Car> winners) {
		StringJoiner stringJoiner = new StringJoiner(",");
		for (Car winner : winners) {
			stringJoiner.add(winner.getName());
		}
		output.printWinners(stringJoiner);
	}
}
