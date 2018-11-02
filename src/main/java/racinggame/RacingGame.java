package racinggame;

import java.util.*;

/**
 * Created by hspark on 02/11/2018.
 */
public class RacingGame {
	private static final Random random = new Random();
	private static final int STANDARD_SCORE = 5;
	private static final int MAX_SCORE = 9;

	private List<Car> cars;
	private int tryCount;

	public RacingGame(int carAmount, int tryCount) {
		this.cars = new ArrayList<>();
		for (int i = 0; i < carAmount; i++) {
			cars.add(new Car());
		}
		this.tryCount = tryCount;
	}

	public List<Car> move() {
		tryCount -= 1;
		for (Car car : cars) {
			moveCar(car);
		}
		return getCars();
	}

	private void moveCar(Car car) {
		if (isAvailableMoving()) {
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

	protected boolean isAvailableMoving() {
		return random.nextInt(MAX_SCORE + 1) > STANDARD_SCORE;
	}

	public int getRemainTryCount() {
		return tryCount;
	}
}
