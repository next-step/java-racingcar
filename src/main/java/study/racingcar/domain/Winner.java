package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Winner {
	private final List<Car> cars;

	public Winner(List<Car> cars) {
		this.cars = cars;
	}

	public int maxPosition(){
		return cars.stream()
					.mapToInt(Car::carPosition)
					.max()
					.orElseThrow(NoSuchElementException::new);
	}

	public List<String> whoIsWinner(int maxPosition) {
		List<String> winnerNames = new ArrayList<>();
		for (Car car : cars) {
			compareMaxPosition(maxPosition, winnerNames, car);
		}
		return winnerNames;
	}

	private void compareMaxPosition(int maxPosition, List<String> winnerNames, Car car) {
		if(car.isMaxPosition(maxPosition)){
			winnerNames.add(car.carName());
		}
	}
}
