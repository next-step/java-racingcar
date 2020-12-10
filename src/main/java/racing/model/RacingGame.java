package racing.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

	private final RacingCars racingCars;

	public RacingGame(int carNumber) {

		this.racingCars = new RacingCars(carNumber);
	}

	public RacingGame(String[] names) {

		this.racingCars = new RacingCars(names);
	}

	public void start() {

		this.racingCars.start();
	}

	public RacingCars getRacingCars() {

		return this.racingCars;
	}

	public String getWinner() {

		List<RacingCar> cars = this.racingCars.getCars();

		// 최대 주행거리
		int maxDistance = cars.stream()
			.mapToInt(RacingCar::getDistance)
			.max()
			.orElse(0);

		return cars.stream()
			.filter(racingCar -> racingCar.getDistance() == maxDistance)
			.map(RacingCar::getCarName)
			.collect(Collectors.joining(", "));
	}
}
