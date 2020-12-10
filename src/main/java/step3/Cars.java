package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
	private final List<Car> cars;

	public Cars(int carNumber, NumberGenerator numberGenerator) {
		this.cars = IntStream.range(0, carNumber)
			.boxed()
			.map(integer -> new Car(numberGenerator))
			.collect(Collectors.toList());
	}

	Car get(int index) {
		return cars.get(index);
	}

	public void goOrStop(){
		cars.forEach(Car::goOrStop);
	}

	public List<Car> cloneList() {
		return this.cars.stream()
			.map(Car::clone)
			.collect(Collectors.toList());
	}
}
