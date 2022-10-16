package study.step5.domain.car;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import study.step5.domain.movestrategy.MoveStrategy;

public class Cars implements Iterable<Car> {
	private List<Car> cars;

	public Cars() {};

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Cars createByNames(List<String> names) {
		List<Car> carList = names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
		return new Cars(carList);
	}

	public Cars getAllByPosition(int position) {
		return new Cars(
			this.cars
				.stream()
				.map(car -> car.getByPosition(position))
				.filter(Objects::nonNull)
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

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}

	@Override
	public void forEach(Consumer<? super Car> action) {
		Iterable.super.forEach(action);
	}

	public String getNames() {
		return this.cars.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));
	}
}
