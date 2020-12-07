package race;

import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
	private final List<Car> cars;

	private CarGroup(InputValue inputValue, MovePolicy movePolicy) {
		this.cars = inputValue.names().stream()
			.map(name -> Car.ofName(name, movePolicy))
			.collect(Collectors.toList());
	}

	public static CarGroup ofInputValues(InputValue names, MovePolicy movePolicy) {
		return new CarGroup(names, movePolicy);
	}

	public boolean ofCarName(String name) {
		return this.cars.stream().anyMatch(car -> car.getNameValue().equals(name));
	}

	public void moveAll() {
		cars.forEach(Car::move);
	}

	public List<Car> nowCarStatus() {
		return cars;
	}

}
