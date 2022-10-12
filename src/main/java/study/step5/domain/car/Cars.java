package study.step5.domain.car;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import study.step5.domain.movestrategy.MoveStrategy;

public class Cars implements Iterable<Car>{
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Cars getAllByPosition(int position) {
		return new Cars(
			this.cars
				.stream()
				.filter(car -> car.getPosition() == position)
				.collect(Collectors.toList())
		);
	}

	public int findMaxPosition() {
		return this.cars
			.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	public void moveAll(MoveStrategy moveStrategy) {
		this.cars.forEach(car -> car.move(moveStrategy));
	}

	public void printName() {
		System.out.print(this.cars.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", ")));
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}

	@Override
	public void forEach(Consumer<? super Car> action) {
		Iterable.super.forEach(action);
	}
}
