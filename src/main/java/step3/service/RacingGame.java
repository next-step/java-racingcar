package step3.service;

import java.util.Random;

import step3.domain.Car;
import step3.exception.RaceParamUnvalidException;

public final class RacingGame {
	public static final int RANDOM_BOUND = 10;

	/**
	 @return : int[moveIndex][carIndex]
	 */
	public static int[][] race(int carCount, int moveCount) {
		if (carCount < 1 || moveCount < 1) {
			throw new RaceParamUnvalidException();
		}
		Car[] cars = makeCars(carCount);
		int[][] raceResult = new int[moveCount][carCount];
		for (int moveIndex = 0; moveIndex < moveCount; moveIndex++) {
			raceResult[moveIndex] = moveCars(cars);
		}
		return raceResult;
	}

	private static Car[] makeCars(int carCount) {
		Car[] cars = new Car[carCount];
		for (int i = 0; i < carCount; i++) {
			cars[i] = new Car();
		}
		return cars;
	}

	private static int[] moveCars(Car[] cars) {
		Random random = new Random();
		int[] movedResult = new int[cars.length];
		for (int carIndex = 0; carIndex < cars.length; carIndex++) {
			cars[carIndex].move(random.nextInt(RANDOM_BOUND));
			movedResult[carIndex] = cars[carIndex].getPosition();
		}

		return movedResult;
	}
}
