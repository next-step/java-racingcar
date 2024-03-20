package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

import racingcar.view.OutputView;

public class RacingCars {
	Random random = new Random();
	List<Car> cars = new ArrayList<>();
	OutputView output = new OutputView();

	public String[] splitName(String carName) {
		return carName.split(",");
	}

	public void addCarsToList(String carNames) {
		String[] carNameList = splitName(carNames);
		for (int i = 0; i < carNameList.length; i++) {
			Car car = new Car(carNameList[i]);
			cars.add(car);
		}
	}

	public void conductCarRacing(int trialNumber) {
		for (int i = 0; i < trialNumber; i++) {
			moveCars();
			output.moveCars(cars);
		}
	}

	public void moveCars() {
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
		if (car.getPosition() == maxPosition())
			winners.add(car);
	}

	private void viewWinners(List<Car> winners) {
		StringJoiner stringJoiner = new StringJoiner(",");
		for (Car winner : winners) {
			stringJoiner.add(winner.getName());
		}
		System.out.println(String.format("%s 가 최종 우승했습니다", stringJoiner));
	}

	public int maxPosition() {
		return cars.stream()
			.max(Comparator.comparing(Car::getPosition))
			.map(Car::getPosition)
			.orElseThrow(() -> new IllegalStateException("car.position cannot get max"));
	}
}
