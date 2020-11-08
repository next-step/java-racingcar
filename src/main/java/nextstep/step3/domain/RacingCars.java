package nextstep.step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {
	private List<RacingCar> racingCars;

	public RacingCars(int carNumber) {
		racingCars = IntStream.range(0, carNumber)
				.mapToObj(RacingCar::new)
				.collect(Collectors.toList());
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}
}
