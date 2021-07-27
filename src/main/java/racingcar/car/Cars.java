package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private static final int INITIAL_POSITION = 0;
	private static final String DELIMITER = ",";
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars of(String carNames) {
		List<Car> cars = new ArrayList<>();
		String[] names = carNames.split(DELIMITER);
		for (String name : names) {
			cars.add(new Car(new CarName(name)));
		}
		return new Cars(cars);
	}

	public void move(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}

	public List<Car> cars() {
		return cars;
	}

	public List<Car> getRaceWinners() {
		int maxPosition = getMaxPosition();
		return cars.stream()
				.filter(car -> car.isMaxPosition(maxPosition))
				.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		int maxPosition = INITIAL_POSITION;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

}
