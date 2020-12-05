package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGroup {
	private final List<Car> cars;

	private CarGroup(int groupSize, MovePolicy movePolicy) {
		this.cars = IntStream.rangeClosed(1, groupSize).mapToObj(i -> Car.of(movePolicy)).collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}

	public Car ofCarIndex(int carIndex) {
		return this.cars.get(carIndex);
	}

	public void moveAll() {
		cars.forEach(Car::move);
	}

	public List<Car> nowCarStatus() {
//		return cars.stream().map(Car::nowDistance).collect(Collectors.toList());
		return cars;
	}

	public static CarGroup of(int groupSize, MovePolicy movePolicy) {
		return new CarGroup(groupSize, movePolicy);
	}
}
