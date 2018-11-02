package racinggame;

import racinggame.rule.RacingGameRule;

import java.util.*;

/**
 * Created by hspark on 02/11/2018.
 */
public class RacingGame {

	private RacingGameRule gameRule;
	private List<Car> cars;
	private int tryCount;

	public RacingGame(int carAmount, int tryCount, RacingGameRule gameRule) {
		this.cars = new ArrayList<>();
		for (int i = 0; i < carAmount; i++) {
			cars.add(new Car());
		}
		this.tryCount = tryCount;
		this.gameRule = gameRule;
	}

	public List<Car> move() {
		tryCount -= 1;
		for (Car car : cars) {
			moveCar(car);
		}
		return getCars();
	}

	private void moveCar(Car car) {
		if (gameRule.isAvailableMoving()) {
			car.moveForward();
		}
	}

	public List<Car> getCars() {
		List<Car> deepCopyList = new ArrayList();
		for (Car car : cars) {
			deepCopyList.add(new Car(car));
		}
		return deepCopyList;
	}

	public boolean hasNextGame() {
		return tryCount > 0;
	}

	public int getRemainTryCount() {
		return tryCount;
	}
}
