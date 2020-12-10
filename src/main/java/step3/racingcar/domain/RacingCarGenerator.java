package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGenerator {
	public static RacingCars generate(final String[] carNames) {
		final List<RacingCar> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new RacingCar(carName));
		}
		return new RacingCars(cars);
	}

}
