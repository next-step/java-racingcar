package racinggame;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.comparator.WinnerComparator;
import racinggame.domain.Car;

public class RacingGameResult {

	private List<Car> cars;

	public RacingGameResult(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getWinners() {
		Car winner = cars.stream()
				.max(new WinnerComparator())
				.get();
		return cars.stream()
				.filter(car -> car.isSamePosition(winner))
				.collect(Collectors.toList());
	}
}
