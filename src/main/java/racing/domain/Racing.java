package racing.domain;

import java.util.List;

public class Racing {

	private final Cars cars;

	private Racing(String carsName) {
		cars = new Cars(carsName);
	}

	private Racing(Cars cars) {
		this.cars = cars;
	}

	public static Racing raceStart(String carsName) {
		return new Racing(carsName);
	}

	public static Racing raceStart(Cars car) {
		return new Racing(car);
	}

	public Cars carsRaceForResult() {
		return cars.racing(new RandomMoving());
	}

	public List<Car> winnerPlayer() {
		return cars.winnerCars();
	}

}
