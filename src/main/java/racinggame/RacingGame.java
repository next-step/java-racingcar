package racinggame;

import racinggame.car.Car;
import racinggame.car.CarDTO;
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

	public RacingGame(String[] carNames, int tryCount, RacingGameRule gameRule) {
		this.cars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
		this.tryCount = tryCount;
		this.gameRule = gameRule;
	}

	public void move() {
		reduceTryCount();
		for (Car car : cars) {
			car.moveForward(gameRule);
		}
	}

	public List<CarDTO> getTopRankingCarDtoList() {
		int maxValue = getMaxPosition();
		return this.cars.stream().filter(car -> car.getPosition() == maxValue)
			.map(CarDTO::of).collect(Collectors.toList());
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

	private int getMaxPosition() {
		return this.cars.stream().max(Comparator.comparingInt(Car::getPosition))
			.orElseThrow(ArrayIndexOutOfBoundsException::new).getPosition();
	}
}
