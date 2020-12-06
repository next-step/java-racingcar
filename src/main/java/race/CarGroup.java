package race;

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

	public Car ofCarIndex(int carIndex) {
		return this.cars.get(carIndex);
	}

	public void moveAll() {
		cars.forEach(Car::move);
	}

	public List<Car> nowCarStatus() {
		return cars;
	}

	public static CarGroup of(int groupSize, MovePolicy movePolicy) {
		return new CarGroup(groupSize, movePolicy);
	}
}
