package nextstep.step3.domain;

import java.util.Comparator;
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

	public List<String> getRacingWinnerNames() {
		int maxPoint = racingCars.stream()
				.max(Comparator.comparing(RacingCar::getPoint))
				.get().getPoint();

		return racingCars.stream()
				.filter(car -> maxPoint == car.getPoint())
				.map(RacingCar::getName)
				.collect(Collectors.toList());
	}
}
