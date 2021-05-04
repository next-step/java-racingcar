package racing;

import static racing.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class Winners {
	private final List<Winner> winners = new ArrayList<>();

	public Winners(List<Car> cars) {
		if (cars.isEmpty()) {
			throw new IllegalArgumentException(ERR_EMPTY_CARS);
		}

		List<Car> copyList = new ArrayList<>(cars);
		copyList.sort((o1, o2) -> (Integer.compare(o2.getMoveCount(), o1.getMoveCount())));
		Car winner = copyList.get(FIRST_WINNER);
		for (Car car : cars) {
			addWinner(winner, car);
		}
	}

	private void addWinner(Car winner, Car car) {
		if (winner.getMoveCount() == car.getMoveCount()) {
			winners.add(new Winner(car));
		}
	}

	public String getWinnerNames() {
		StringBuilder stb = new StringBuilder();
		for (Winner winner : winners) {
			stb.append(winner.getName()).append(DELIMITER);
		}
		return stb.substring(0, stb.length() - 1);
	}
}
