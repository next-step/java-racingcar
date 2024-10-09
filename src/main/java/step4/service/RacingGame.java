package step4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import step4.domain.Car;
import step4.domain.CarMoveStrategy;
import step4.domain.DefaultRandomMoveStrategy;
import step4.domain.MovedHistory;
import step4.domain.RacingHistory;
import step4.exception.RaceParamUnvalidException;

public final class RacingGame {
	private static final CarMoveStrategy defaultRandomMoveStrategy = new DefaultRandomMoveStrategy(new Random());

	public static List<Car> makeCars(Integer carCount) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
		for (Car car : cars) {
			car.setMoveStrategy(defaultRandomMoveStrategy);
		}
		return cars;
	}

	public static RacingHistory race(int carCount, int moveCount) {
		throwExceptionIfParamsNotValid(carCount, moveCount);

		List<Car> cars = makeCars(carCount);

		RacingHistory racingHistory = new RacingHistory();
		for (int i = 0; i < moveCount; i++) {
			racingHistory.writePositionHistory(moveCars(cars));
		}
		return racingHistory;
	}

	private static void throwExceptionIfParamsNotValid(int carCount, int moveCount) {
		if (carCount < 1 || moveCount < 1) {
			throw new RaceParamUnvalidException();
		}
	}

	private static MovedHistory moveCars(List<Car> cars) {
		for (Car car : cars) {
			car.move(car.getMoveStrategy().movable());
		}

		return MovedHistory.from(cars);
	}
}
