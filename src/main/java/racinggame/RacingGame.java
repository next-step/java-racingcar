package racinggame;

import racinggame.rule.RacingGameRule;

import java.util.*;
import java.util.stream.Collectors;

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

	public void move() {
		reduceTryCount();
		for (Car car : cars) {
			car.moveForward(gameRule);
		}
	}

	private void reduceTryCount() {
		tryCount -= 1;
	}

	public List<CarDTO> getCarDtoList() {
		return cars.stream().map(CarDTO::of).collect(Collectors.toList());

	}

	public boolean hasNextGame() {
		return tryCount > 0;
	}
}
