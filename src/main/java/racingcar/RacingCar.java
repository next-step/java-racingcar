package racingcar;

import java.util.Random;

public class RacingCar {
	public static void run() {
		int carCount = InputView.totalCarCount();
		Car[] cars = initCarArray(carCount);

		int tryCount = InputView.totalTryCount();
		System.out.println("실행결과");
		for (int i = 0; i < tryCount; i++) {
			moveCars(cars);
			System.out.println();
		}
	}

	private static void moveCars(Car[] cars) {
		int moveResult;
		for (Car car : cars) {
			moveResult = car.tryMove(RandomUtils.createRandomNumber());
			ResultView.printMove(moveResult);
		}
	}

	private static Car[] initCarArray(int carCount) {
		Car[] cars = new Car[carCount];
		for(int i = 0; i < carCount; i++) {
			cars[i] = new Car();
		}
		return cars;
	}
}
