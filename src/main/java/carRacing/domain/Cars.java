package carRacing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public Cars(String carNames) {
		this.cars = new ArrayList<>();
		for (String carName : carNames.split(",")) {
			this.addCar(carName, 0);
		}
	}

	public void addCar(String name, int location) {
		this.cars.add(new Car(name, location));
	}

	public List<Car> findWinners() {
		Location bestLocation = this.extractBestLocation();

		List<Car> winners = new ArrayList<>();
		for (Car car : this.cars) {
			this.addWinner(bestLocation, winners, car);
		}

		return winners;
	}

	public Location extractBestLocation() {
		Location bestLocation = new Location(0);
		for (Car car : this.cars) {
			bestLocation = car.greaterLocation(bestLocation);
		}
		return bestLocation;
	}

	private void addWinner(Location bestLocation, List<Car> winners, Car car) {
		if (car.isWinner(bestLocation)) {
			winners.add(car);
		}
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
