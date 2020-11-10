package nextstep.step3.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarWinners {
	public List<String> getRacingWinnerNames(List<RacingCar> racingCars) {
		int maxPoint = racingCars.stream()
				.max(Comparator.comparing(RacingCar::getPoint))
				.get().getPoint();

		return racingCars.stream()
				.filter(car -> maxPoint == car.getPoint())
				.map(RacingCar::getName)
				.collect(Collectors.toList());
	}
}
