package step5.model;

import step5.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final String SPLIT_STANDARD = ",";

	private final List<Car> cars;

	public Cars(String names){
		this.cars = initCars(names);
	}

	public Cars(final List<Car> list){
		this.cars = list;
	}

	public List<Car> getCars() {
		return cars;
	}

	List<Car> initCars(String nameInput) {
		String[] names = nameInput.split(SPLIT_STANDARD);
		return Arrays.stream(names)
				.map(Car::new)
				.collect(Collectors.toList());
	}

	public void decideMove(MoveStrategy moveStrategy) {
		this.cars.forEach(car -> car.move(moveStrategy));
	}
}
