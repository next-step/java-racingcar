package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGenerator {

	public static List<RacingCar> generate(final int participateCarCount) {
		List<RacingCar> cars = new ArrayList<>();
		for (int i = 0; i < participateCarCount; i++) {
			cars.add(new RacingCar(i+1));
		}
		return cars;
	}

}
