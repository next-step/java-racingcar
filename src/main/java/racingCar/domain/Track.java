package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Track {
	private final List<Car> carList;

	public Track(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> getCarList() {
		return carList;
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
		int maxDistance = findMaxDistance();

		return carList.stream()
			.filter(car -> car.getDistanceAmount() == maxDistance)
			.collect(Collectors.toList());
	}

	private int findMaxDistance() {
		return carList.stream()
			.mapToInt(Car::getDistanceAmount)
			.max()
			.orElse(0);
	}
}
