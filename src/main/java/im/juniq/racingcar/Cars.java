package im.juniq.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
	private List<Car> cars = new ArrayList<>();

	public Cars(Car... car) {
		cars.addAll(Arrays.asList(car));
	}

	public void createCars(String[] carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public List<Car> findByTopPosition() {
		int topPosition = cars.stream()
				.mapToInt(Car::getPosition)
				.max().orElseThrow(()  -> new RuntimeException("position 수치가 가장 높은 차를 구할 수 없음."));

		return cars.stream().filter(car -> topPosition == car.getPosition())
			.collect(Collectors.toCollection(ArrayList::new));
	}

	public Car get(int index) {
		return cars.get(index);
	}

	public int size() {
		return cars.size();
	}

	@Override
	public Iterator<Car> iterator() {
		return new CarIterator();
	}

	private class CarIterator implements Iterator<Car> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < cars.size();
		}

		@Override
		public Car next() {
			return cars.get(index++);
		}
	}
}
