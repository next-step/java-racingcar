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
		tryCount -= 1;
		for (Car car : cars) {
			moveCar(car);
		}
	}

	private void moveCar(Car car) {
		car.moveForward(gameRule);
	}

	public List<CarDTO> getCarDtoList() {
		return cars.stream().map(CarDTO::of).collect(Collectors.toList());

	}

	public boolean hasNextGame() {
		return tryCount > 0;
	}
}
