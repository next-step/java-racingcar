package racinggame.domain;

import racinggame.domain.car.Car;
import racinggame.domain.car.CarDTO;
import racinggame.domain.rule.RacingGameRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hspark on 02/11/2018.
 */
public class RacingGame {

	private RacingGameRule gameRule;
	private List<Car> cars;
	private int tryCount;

	public RacingGame(List<Car> cars, int tryCount, RacingGameRule gameRule) {
		this.gameRule = gameRule;
		this.cars = cars;
		this.tryCount = tryCount;
	}

	public RacingGame(String[] carNames, int tryCount, RacingGameRule gameRule) {
		this.cars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
		this.tryCount = tryCount;
		this.gameRule = gameRule;
	}

	public void move() {
		reduceTryCount();
		cars.stream().forEach((car) -> car.moveForward(gameRule));
	}

	private void reduceTryCount() {
		tryCount -= 1;
	}

	public List<CarDTO> getCarDtoList() {
		return getCars().stream().map(CarDTO::new).collect(Collectors.toList());
	}

	public boolean hasNextGame() {
		return tryCount > 0;
	}

	public RacingGameResult getGameResult() {
		return new RacingGameResult(getCarDtoList());
	}

	private List<Car> getCars() {
		return cars;
	}
}
