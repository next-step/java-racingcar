package racing.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CarGroup {
	private final List<Car> carList;

	public static CarGroup of(List<String> carNameList, MoveForwardStrategy moveForwardStrategy) {
		List<Car> carList = new ArrayList<>();
		for (String carName : carNameList) {
			final Car car = createCar(carName, moveForwardStrategy);
			carList.add(car);
		}

		return new CarGroup(carList);
	}

	CarGroup(List<Car> carList) {
		this.carList = carList;
	}

	private static Car createCar(String carName, MoveForwardStrategy moveForwardStrategy) {
		return new Car(carName, moveForwardStrategy);
	}

	public Stream<Car> stream() {
		return carList.stream();
	}

	public void getMoveForwardChance() {
		for (Car car : carList) {
			car.getMoveForwardChance();
		}
	}
}
