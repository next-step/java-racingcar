package racing.model.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {

	private final List<Car> cars;

	public CarList(int numberOfCars, String[] carNames) {
		cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car(4, 1, new Position(1), new CarName(carNames[i])));
		}
	}

	public CarList(int numberOfCars) {
		cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car(4, 1, new Position(1), null));
		}
	}

	public void moveAll(List<Integer> bounds) {
		int numberOfCars = cars.size();
		for (int i = 0; i < numberOfCars; i++) {
			cars.get(i).move(bounds.get(i));
		}
	}

	public int numberOfCars() {
		return cars.size();
	}

	public List<Integer> getAllPosition() {
		List<Integer> result = new ArrayList<>();
		for (Car car : cars) {
			result.add(car.position().current());
		}
		return result;
	}

	private int maxPosition() {
		int result = 0;
		for (Car car : cars) {
			result = Math.max(result, car.position().current());
		}
		return result;
	}

	private boolean isWinner(Car car, int maxPosition) {
		if (car.position().match(maxPosition)) {
			return Result.WINNER;
		}
		return Result.LOSER;
	}

	private void addWinner(int maxPosition, List<String> winners, int i) {
		if (isWinner(cars.get(i), maxPosition)) {
			winners.add(cars.get(i).name());
		}
	}

	public List<String> winners() {
		int maxPosition = maxPosition();
		List<String> winners = new ArrayList<>();

		int numberOfCars = cars.size();
		for (int i = 0; i < numberOfCars; i++) {
			addWinner(maxPosition, winners, i);
		}
		return winners;
	}

	public String status(int index) {
		StringBuilder result = new StringBuilder();

		int position = cars.get(index).position().current();
		result.append(cars.get(index).name()).append(" : ");
		result.append("-".repeat(Math.max(0, position)));
		return result.toString();
	}

}
