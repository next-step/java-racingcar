package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {

	private List<Car> cars;
	private int maxPosition;

	public Racing(List<Name> names) {
		generateCars(names);
	}

	private void generateCars(List<Name> names) {
		this.cars = new ArrayList<>();
		for (Name name : names) {
			cars.add(new Car(name));
		}
	}

	public List<Result> race(MoveStrategy moveStrategy) {
		List<Result> result = new ArrayList<>();
		for (Car car : cars) {
			car.move(moveStrategy.isMovable());
			result.add(new Result(car.getPosition(), car.getName()));
			updateMaxPosition(car);
		}
		return result;
	}

	private void updateMaxPosition(Car car) {
		maxPosition = Math.max(maxPosition, car.getPosition());
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<String> getWinners() {
		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			chooseWinner(winners, car);
		}
		return winners;
	}

	private void chooseWinner(List<String> winners, Car car) {
		if (isWinner(car)) {
			winners.add(car.getName());
		}
	}

	private boolean isWinner(Car car) {
		return car.getPosition() == maxPosition;
	}
}
