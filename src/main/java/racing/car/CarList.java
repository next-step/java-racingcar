package racing.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {

	private static final boolean WINNER = true;
	private static final boolean LOSER = false;
	private final List<Car> cars;

	public CarList(int numberOfCars, String[] carNames) {
		cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car(4, 1, 1, new CarName(carNames[i])));
		}
	}

	public CarList(int numberOfCars) {
		cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car(4, 1, 1, null));
		}
	}

	public void moveAll(int[] bounds) {
		int numberOfCars = cars.size();
		for (int i = 0; i < numberOfCars; i++) {
			cars.get(i).move(bounds[i]);
		}
	}

	public int getNumberOfCars() {
		return cars.size();
	}

	public List<Integer> getAllPosition() {
		List<Integer> result = new ArrayList<>();
		for (Car car : cars) {
			result.add(car.getPosition());
		}
		return result;
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
		if (isWinner(cars.get(i), maxPosition)) {
			winners.add(cars.get(i).getName());
		}
	}

	public List<String> getWinners() {
		int maxPosition = getMaxPosition();
		List<String> winners = new ArrayList<>();

		int numberOfCars = cars.size();
		for (int i = 0; i < numberOfCars; i++) {
			addWinner(maxPosition, winners, i);
		}
		return winners;
	}

	public String getStatus(int index) {
		StringBuilder result = new StringBuilder();

		int position = cars.get(index).getPosition();
		result.append(cars.get(index).getName()).append(" : ");
		for (int i = 0; i < position; i++) {
			result.append("-");
		}
		result.append("\n");
		return result.toString();
	}

}
