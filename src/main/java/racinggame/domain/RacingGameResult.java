package racinggame.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import racinggame.comparator.WinnerComparator;
import racinggame.dto.CarDto;

public class RacingGameResult {

	public static final String JOIN_DELIMITER = ", ";

	private List<Car> cars;

	public RacingGameResult(List<Car> cars) {
		this.cars = cars;
	}

	public List<String> getPrintPositions(String displayCharacter) {
		List<CarDto> carDtos = toDto();
		return carDtos.stream()
				.map(carDto -> carDto.print(displayCharacter))
				.collect(Collectors.toList());
	}

	private List<CarDto> toDto() {
		return cars.stream()
				.map(CarDto::new)
				.collect(Collectors.toList());
	}

	public String getWinnerNames() {
		StringJoiner names = new StringJoiner(JOIN_DELIMITER);
		List<Car> winners = getWinners();
		for(Car car : winners) {
			names.add(car.getName());
		}
		return names.toString();
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
