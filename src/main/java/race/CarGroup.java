package race;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGroup {
	public static final int INIT_GROUP_SIZE_INDEX = 0;
	private final List<Car> cars;

	private CarGroup(int groupSize, MovePolicy movePolicy) {
		this.cars = IntStream.range(INIT_GROUP_SIZE_INDEX, groupSize)
			.mapToObj(i -> Car.of(movePolicy))
			.collect(Collectors.toList());
	}

	private CarGroup(String separator, String names, MovePolicy movePolicy) {
		this.cars = Arrays.stream(names.split(separator))
			.map(name -> Car.ofName(name, movePolicy))
			.collect(Collectors.toList());
	}

	public static CarGroup ofNames(String inputNameSeparator, String names, MovePolicy movePolicy) {
		return new CarGroup(inputNameSeparator, names, movePolicy);
	}

	public static CarGroup of(int groupSize, MovePolicy movePolicy) {
		return new CarGroup(groupSize, movePolicy);
	}

	public Car ofCarIndex(int carIndex) {
		return this.cars.get(carIndex);
	}

	public boolean ofCarName(String name) {
		return this.cars.stream().anyMatch(car -> car.getName().equals(name));
	}

	public void moveAll() {
		cars.forEach(Car::move);
	}

	public List<Car> nowCarStatus() {
		return cars;
	}

}
