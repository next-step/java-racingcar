package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class Cars {

	private List<Car> cars;
	private int matchCount;
	private int lapCount;
	private RaceHistory raceHistory;

	public Cars(String[] carNames, int matchCount) {
		this.cars = new ArrayList<>();
		createCars(carNames);
		this.matchCount = matchCount;
		this.lapCount = 0;
		raceHistory = new RaceHistory();
	}

	public int getCount() {
		return cars.size();
	}

	public Cars race() {
		while (matchCount != lapCount) {
			runLap();
		}
		return this;
	}

	public void runLap() {
		List<Car> lapFinishCars = new ArrayList<>();
		for (Car car : cars) {
			car.randomMove();
			lapFinishCars.add(new Car(car));
		}
		raceHistory.add(lapFinishCars);
		lapCount++;
	}

	public int getLapCount() {
		return lapCount;
	}

	private void createCars(String[] carNames) {
		IntStream.range(0, carNames.length).forEach(i -> cars.add(new Car(carNames[i])));
	}

	public RaceHistory getHistory() {
		return raceHistory;
	}

	public List<Car> get() {
		return cars;
	}

}
