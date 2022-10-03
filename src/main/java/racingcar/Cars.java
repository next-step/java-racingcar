package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars extends Condition{
	private final List<Car> cars = new ArrayList<>();

	public Cars(String[] cars) {
		super(new NameCondition());
		for (String carName : cars) {
			validName(carName);
		}
	}

	private void validName(String carName) {
		if (validInput(carName)) {
			this.cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}
