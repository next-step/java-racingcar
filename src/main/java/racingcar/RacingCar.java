package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
	public static void run() {
		int carCount = InputView.totalCarCount();
		Cars cars = initCars(carCount);

		int tryCount = InputView.totalTryCount();
		System.out.println("실행결과");
		for (int i = 0; i < tryCount; i++) {
			cars.moveCars();
			System.out.println();
		}
	}

	private static Cars initCars(int carCount) {
		List<Car> cars = new ArrayList<>();
		for(int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
		return new Cars(cars);
	}
}
