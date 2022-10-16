package step5.model;

import step5.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final String SPLIT_STANDARD = ",";

	private final List<Car> cars;

	public Cars(final List<Car> list){
		this.cars = list;
	}

	public static Cars inits(String nameInput){
		String[] names = nameInput.split(SPLIT_STANDARD);
		return new Cars(Arrays.stream(names)
				.map(Car::new)
				.collect(Collectors.toList()));
	}

	public List<Car> getCars() {
		return cars;
	}

	public void decideMove(MoveStrategy moveStrategy) {
		this.cars.forEach(car -> car.move(moveStrategy));
	}
}
