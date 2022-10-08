package step4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

	private static final String DELIMITER = ", ";

	private final List<String> winners;

	public Winners() {
		winners = new ArrayList<>();
	}

	public String getWinners(final Cars cars) {
		checkWinners(cars);
		return winners.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(DELIMITER));
	}

	public void checkWinners(final Cars cars) {
		int maxMoveCnt = getWinnerStandard(cars);
		for (Car car : cars.getCars()) {
			isWinner(maxMoveCnt, car);
		}
	}

	public int getWinnerStandard(final Cars cars) {
		int maxMoveCnt = 0;
		for (Car car : cars.getCars()) {
			maxMoveCnt = car.maxPosition(maxMoveCnt);
		}
		return maxMoveCnt;
	}

	private void isWinner(final int maxMoveCnt, final Car car) {
		if (car.isMaxPosition(maxMoveCnt)) {
			winners.add(car.getName());
		}
	}
}
