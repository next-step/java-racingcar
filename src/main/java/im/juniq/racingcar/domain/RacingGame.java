package im.juniq.racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private List<Car> cars = new ArrayList<>();

	public RacingGame(Car... car) {
		cars.addAll(Arrays.asList(car));
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

	private List<Car> findByTopPosition() {
		Position topPosition = cars.stream()
			.map(Car::position)
			.max(Position::compareTo)
			.orElseThrow(() -> new RuntimeException("position 수치가 가장 높은 차를 구할 수 없음."));

		return cars.stream().filter(car -> car.position().equals(topPosition))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public List<CarState> getWinners() {
		return findByTopPosition().stream()
				.map(car -> new CarState(car.name().name(), car.position().position()))
				.collect(Collectors.toList());
	}

	public List<CarState> carStates() {
		return cars.stream()
				.map(car -> new CarState(car.name().name(), car.position().position()))
				.collect(Collectors.toList());
	}
}
