package racing.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {

	private final Car[] cars;
	private final int numberOfCars;
	private static final boolean WINNER = true;
	private static final boolean LOSER = false;

	public CarList(int numberOfCars, String[] carNames) {
		this.numberOfCars = numberOfCars;
		cars = new Car[numberOfCars];
		for (int i = 0; i < this.numberOfCars; i++) {
			cars[i] = new Car(4, 1, 1);
			cars[i].setName(carNames[i]);
		}
	}

	public CarList(int numberOfCars) {
		this.numberOfCars = numberOfCars;
		cars = new Car[numberOfCars];
		for (int i = 0; i < this.numberOfCars; i++) {
			cars[i] = new Car(4, 1, 1);
		}
	}

	public void moveAll(int[] bounds) {
		for (int i = 0; i < this.numberOfCars; i++) {
			cars[i].move(bounds[i]);
		}
	}

	public int getNumberOfCars() {
		return numberOfCars;
	}

	public Car get(int index) {
		return cars[index];
	}

	public Car[] getAll() {
		return cars;
	}

	private int getMaxPosition() {
		int result = 0;
		for (Car car : cars) {
			result = Math.max(result, car.getPosition());
		}
		return result;
	}

	private boolean isWinner(Car car, int maxPosition) {
		if (car.getPosition() == maxPosition) {
			return WINNER;
		}
		return LOSER;
	}

	private void addWinner(int maxPosition, List<String> winners, int i) {
		if (isWinner(cars[i], maxPosition)) {
			winners.add(cars[i].getName());
		}
	}

	public List<String> findWinners() {
		int maxPosition = getMaxPosition();
		List<String> winners = new ArrayList<>();
		for (int i = 0; i < this.numberOfCars; i++) {
			addWinner(maxPosition, winners, i);
		}
		return winners;
	}

	public List<String> winners() {
		return findWinners();
	}
}
