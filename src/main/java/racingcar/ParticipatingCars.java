package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ParticipatingCars {
	private List<RacingCar> cars = new ArrayList<>();

	public ParticipatingCars(String carNames) {
		String[] names = carNames.split(",");
		for (String name : names) {
			cars.add(new RacingCar(name));
		}
	}

	public List<RacingCar> get() {
		return cars;
	}
}
