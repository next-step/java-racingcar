package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;
	private final NumberGenerator numberGenerator;

	public Cars(int carCount, NumberGenerator numberGenerator) {
		this.cars = new ArrayList<>();
		for(int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
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
