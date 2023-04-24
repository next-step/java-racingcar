package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Track {
	private final List<Car> carList;

	public Track(List<Car> carList) {
		this.carList = carList;
	}

	public static Track create() {
		List<Car> carList = new ArrayList<>();

		return new Track(carList);
	}

	public void putRaceCar(Car... carList) {
		for (Car car : carList) {
			this.carList.add(car);
		}
	}

	public void run(int round) {
		for (int i = 0; i < round; i++) {
			raceAround();
		}
	}

	public void raceAround() {
		for (Car car : carList) {
			car.drive();
		}
	}

	public List<Car> findWinners() {
		List<Car> winners = new ArrayList<>();

		checkWinner(winners);

		return winners;
	}

	private void checkWinner(List<Car> winners) {
		int maxDistance = 0;

		for (Car car : carList) {
			if (car.getDistanceAmount() == maxDistance) {
				winners.add(car);
			}
			if (car.getDistanceAmount() > maxDistance) {
				winners.clear();
				winners.add(car);

				maxDistance = car.getDistanceAmount();
			}
		}
	}

	public List<Car> getCarList() {
		return carList;
	}
}
