package racingcar.domain;


import static racingcar.domain.MoveStrategy.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import java.util.StringJoiner;

public class RacingCars {
	List<Car> cars = new ArrayList<>();

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

	public List<Car> moveCars() {
		for (Car car : cars) {

			int randomNum = random();
			car.moveStrategy(randomNum);

		}
		return cars;
	}

	public String getWinners() {
		List<Car> winners = new ArrayList<>();

		addToWinnersList(winners);
		return viewWinners(winners);
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

	private String viewWinners(List<Car> winners) {
		StringJoiner stringJoiner = new StringJoiner(",");
		for (Car winner : winners) {
			stringJoiner.add(winner.name().toString());
		}
		return stringJoiner.toString();
	}
}
