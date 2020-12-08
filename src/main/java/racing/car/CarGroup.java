package racing.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CarGroup {
	private final List<Car> carList;

	public CarGroup(int carNum, MoveForwardStrategy moveForwardStrategy) {
		this.carList = new ArrayList<>();
		for (int i = 0; i < carNum; i++) {
			carList.add(createCar(moveForwardStrategy));
		}
	}
	
	private static Car createCar(MoveForwardStrategy moveForwardStrategy) {
		return new Car(moveForwardStrategy);
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
