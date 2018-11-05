package racinggame.domain;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.comparator.WinnerComparator;

public class RacingGameResult {

	private List<Car> cars;

	public RacingGameResult(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getWinners() {
		Car winner = getWinner();
		return cars.stream()
				.filter(car -> car.isSamePosition(winner))
				.collect(Collectors.toList());
	}

	private Car getWinner() {
		return cars.stream()
					.max(new WinnerComparator())
					.get();
	}
}
