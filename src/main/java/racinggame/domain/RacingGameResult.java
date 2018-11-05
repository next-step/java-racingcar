package racinggame.domain;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.comparator.WinnerComparator;
import racinggame.dto.CarDto;

public class RacingGameResult {

	private List<Car> cars;

	public RacingGameResult(List<Car> cars) {
		this.cars = cars;
	}

	public List<CarDto> getWinners() {
		Car winner = getWinner();
		return cars.stream()
				.filter(car -> car.isSamePosition(winner))
				.map(CarDto::new)
				.collect(Collectors.toList());
	}

	private Car getWinner() {
		return cars.stream()
					.max(new WinnerComparator())
					.get();
	}

	public List<CarDto> getCars() {
		return cars.stream()
				.map(CarDto::new)
				.collect(Collectors.toList());
	}
}
