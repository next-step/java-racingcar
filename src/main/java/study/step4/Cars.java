package study.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void add(Car car) {
		this.cars.add(car);
	}

	public Car get(int index) {
		return this.cars.get(index);
	}

	public int size() {
		return this.cars.size();
	}

	public Cars getAllByPosition(int position) {
		return new Cars(this.cars.stream()
			.filter(car -> car.getPosition() == position)
			.collect(Collectors.toList()));
	}

	public int findMaxPosition() {
		return this.cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	public void moveAll(MoveStrategy moveStrategy) {
		this.cars.forEach(car -> car.move(moveStrategy));
	}

	public void printAll() {
		this.cars.forEach(car ->
				System.out.println(car.getName() + " : " + car.getRepeater()));
	}

	public void printName() {
		System.out.print(this.cars.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", ")));
	}
}
