package racingcar.step3_4;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

	private final List<Car> cars;

	public Winners(List<Car> cars) {
		this.cars = cars;
	}

	public List<Name> getNames() {
		return cars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
