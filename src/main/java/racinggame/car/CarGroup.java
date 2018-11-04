package racinggame.car;

import racinggame.rule.RacingGameRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

	public List<CarDTO> getSamePositionCarDTOList(final int standardPosition) {
		return getCars().stream().filter(car -> car.isEqualPosition(standardPosition))
			.map(CarDTO::new).collect(Collectors.toList());
	}

	public int getMaxPosition() {
		return Collections.max(getCars(), Comparator.comparing(Car::getPosition)).getPosition();
	}

	private List<Car> getCars() {
		return cars;
	}
}
