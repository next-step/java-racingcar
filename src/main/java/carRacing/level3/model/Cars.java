package carRacing.level3.model;

import carRacing.level3.error.NotFoundCarsException;
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
		int maxLocation = cars.stream()
			.map(Car::carLocation)
			.mapToInt(Location::getLocation)
			.max()
			.orElseThrow(() -> new NotFoundCarsException("자동차 리스트가 비어있습니다"));

		return new Location(maxLocation);
	}

	public Location carLocation(int i) {
		return cars.get(i).carLocation();
	}

	public Car car(int carNum) {
		return cars.get(carNum);
	}

	public int totalNum() {
		return cars.size();
	}


}

