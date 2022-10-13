package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars create(List<String> carNames) {
		List<Car> cars = carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());

		return new Cars(cars);
	}

	public static Cars addCarList(List<Car> carList) {
		return new Cars(carList);
	}

	public void moveCarLocation(MovingStrategy movingStrategy) {
		cars.forEach(car ->
			car.moveLocation(movingStrategy));
	}

	public Location maxLocation() {
		Location location = new Location();
		return location.maxLocation(cars);
	}

	public Car car(int carNum) {
		return cars.get(carNum);
	}

	public int totalNum() {
		return cars.size();
	}


}

