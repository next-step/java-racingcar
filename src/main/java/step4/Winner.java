package step4;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
	public List<Car> findWinner(List<Car> cars) {
		int winnerRecord = cars.stream()
				.mapToInt(Car::getRecord)
				.max()
				.getAsInt();

		return cars.stream()
				.filter(car -> car.getRecord() == winnerRecord)
				.collect(Collectors.toList());
	}
}
