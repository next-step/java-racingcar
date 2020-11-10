package nextstep.step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
	private List<RacingCar> racingCars;

	public RacingCars(List<String> carNames) {
		racingCars = carNames.stream()
				.map(RacingCar::new)
				.collect(Collectors.toList());
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}
}
