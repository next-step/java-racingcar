package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

	private final Cars cars;
	private final int racingRoundCount;

	private Racing(Cars cars) {
		this.cars = cars;
		racingRoundCount = 0;
	}

	private Racing(String carsName, int racingRoundCount) {
		cars = new Cars(carsName);
		this.racingRoundCount = racingRoundCount;
	}

	public Racing(Cars cars, int racingRoundCount) {
		this.cars = cars;
		this.racingRoundCount = racingRoundCount;
	}

	public static Racing raceStart(Cars car) {
		return new Racing(car);
	}

	public static Racing raceStart(Cars car, int roundCount) {
		return new Racing(car,roundCount);
	}

	public static Racing raceStart(String carsName, int roundCount) {
		return new Racing(carsName, roundCount);
	}

	public List<Cars> carsRaceForResult() {
		List<Cars> roundCarsList = new ArrayList<>();
		for(int i=0;i<racingRoundCount;i++){
			roundCarsList.add(cars.racing());
		}
		return roundCarsList;
	}

	public List<Car> winnerPlayer() {
		return cars.winnerCars();
	}

}
