package step3_racingcar;

import java.util.ArrayList;
import java.util.List;

import step3_racingcar.domain.Car;

public class GameProcess {

	public List<List<Car>> play(int tryCount , List<Car> cars ) {
		List<List<Car>> results = new ArrayList<>();

		for (int i = 0; i < tryCount; i++) {
			for (Car car : cars) {
				car.tryMove();
			}

			results.add(new ArrayList<>(cars));
		}

		return results;
	}
}
