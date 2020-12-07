package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;
	private final NumberGenerator numberGenerator;

	public Cars(List<String> carNames, NumberGenerator numberGenerator) {
		this.cars = carNames.stream()
			.map(name -> new Car(name))
			.collect(Collectors.toList());

		this.numberGenerator = numberGenerator;
	}

	public void move() {
		for (Car car : this.cars) {
			car.tryMove(numberGenerator.createNumber());
		}
	}

	public List<Integer> getMoveResult() {
		return cars.stream()
			.map(Car::getMoveCount)
			.collect(Collectors.toList());
	}

	public int sizeOfCars() {
		return this.cars.size();
	}
}
