package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

	private static List<Car> winners = new ArrayList<>();

	public static List<Car> list(Cars cars) {
		int winnersPosition = maxPosition(cars);
		for (int i = 0; i < cars.count(); i++) {
			isWinners(cars.get(i), winnersPosition);
		}
		return winners;
	}

	private static void isWinners(Car car, int winnersPosition) {
		if (car.carStatus().length() == winnersPosition) {
			winners.add(car);
		}
	}

	private static int maxPosition(Cars cars) {
		int position = 0;

		for (int i = 0; i < cars.count(); i++) {
			int currentPosition = cars.get(i).carStatus().length();
			if (position <= currentPosition) {
				position = currentPosition;
			}
		}
		return position;
	}
}
