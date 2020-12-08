package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGenerator {

	public static final String CAR_NAME_DELIMITER = ",";

	public static RacingCars generate(final String carNamesInput) {
		final String[] carNames = carNamesInput.split(CAR_NAME_DELIMITER);
		final List<RacingCar> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new RacingCar(carName));
		}
		return new RacingCars(cars);
	}

}
