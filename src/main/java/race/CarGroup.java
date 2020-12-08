package race;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
	public static final String INPUT_NAME_SEPARATOR = ",";
	private final List<Car> cars;

	private CarGroup(List<CarName> carNames, MovePolicy movePolicy) {
		this.cars = carNames.stream()
			.map(name -> Car.ofName(name, movePolicy))
			.collect(Collectors.toList());
	}

	public static CarGroup ofCarNames(String names, MovePolicy movePolicy) {
		return new CarGroup(generateCarNames(names), movePolicy);
	}

	public static List<CarName> generateCarNames(String names) {
		return makeSeparatorNames(names).stream()
			.map(CarName::of)
			.collect(Collectors.toList());
	}


	private static List<String> makeSeparatorNames(String names) {
		return Arrays.asList(names.split(INPUT_NAME_SEPARATOR));
	}

	public boolean ofCarName(String name) {
		return this.cars.stream().anyMatch(car -> car.getNameValue().equals(name));
	}

	public List<Car> moveAll() {
		List<Car> moveCars = cars.stream()
			.map(Car::move)
			.collect(Collectors.toList());

		return Collections.unmodifiableList(moveCars);
	}

	public List<Car> nowCarStatus() {
		return cars;
	}

}
