package racinggame.car;

import racinggame.rule.RacingGameRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hspark on 04/11/2018.
 */
public class CarGroup {
	private List<Car> cars;

	public CarGroup(String[] carNames) {
		this.cars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
	}

	public void moveForward(RacingGameRule gameRule) {
		for (Car car : getCars()) {
			car.moveForward(gameRule);
		}
	}

	public List<CarDTO> getCarDTOList() {
		return getCars().stream().map(CarDTO::new).collect(Collectors.toList());
	}

	private List<Car> getCars() {
		return cars;
	}
}
