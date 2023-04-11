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
			prepareRace();

			raceOnce();
		}
	}

	private void prepareRace() {
		for (Car car : carList) {
			car.accelerate();
		}
	}

	public void raceOnce() {
		for (Car car : carList) {
			car.drive();
		}
	}

	public List<Car> getCarList() {
		return carList;
	}

}
