package racingcar.car;

import java.util.ArrayList;
import java.util.List;

import racingcar.generator.NumberGenerator;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public Cars(String carNames) {
		this(createCars(carNames));
	}

	private static List<Car> createCars(String carNames) {
		List<Car> newCars = new ArrayList<>();
		String[] carSplitNames = carNames.split(",");
		for (String carName : carSplitNames) {
			newCars.add(new Car(carName));
		}
		return newCars;
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void play(NumberGenerator numberGenerator) {
		for (Car car : cars) {
			car.go(numberGenerator.generate());
		}
	}

	public List<Integer> getPositions() {
		List<Integer> positions = new ArrayList<>();
		for (Car car : cars) {
			positions.add(car.getPosition());
		}
		return positions;
	}
}
