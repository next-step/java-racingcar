package im.juniq.racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame implements Iterable<Car> {
	private List<Car> cars = new ArrayList<>();

	public RacingGame(Car... car) {
		cars.addAll(Arrays.asList(car));
	}

	public RacingGame(List<Car> cars) {
		this.cars = cars;
	}

	public void createCars(String[] carNames, MovingStrategy movingStrategy) {
		for (String carName : carNames) {
			cars.add(new Car(carName, movingStrategy));
		}
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public RacingGame findByTopPosition() {
		int topPosition = cars.stream()
				.mapToInt(Car::getPosition)
				.max().orElseThrow(()  -> new RuntimeException("position 수치가 가장 높은 차를 구할 수 없음."));

		ArrayList<Car> carList = cars.stream().filter(car -> topPosition == car.getPosition())
			.collect(Collectors.toCollection(ArrayList::new));
		return new RacingGame(carList);
	}

	public Car get(int index) {
		return cars.get(index);
	}

	public int size() {
		return cars.size();
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}
}
