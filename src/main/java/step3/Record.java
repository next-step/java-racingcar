package step3;

import java.util.List;
import java.util.stream.Collectors;

public class Record {
	private final List<Car> cars;

	public Record(List<Car> cars) {
		this.cars = cars;
	}

	public List<Integer> getResult() {
		return cars.stream()
			.map(Car::getPosition)
			.collect(Collectors.toList());
	}
}
