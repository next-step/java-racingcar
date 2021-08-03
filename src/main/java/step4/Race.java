package step4;

import java.util.List;

public class Race {
	private NumberContainer numberContainer;

	public Race(NumberContainer numberContainer) {
		this.numberContainer = numberContainer;
	}

	public void startRace(List<Car> cars) {
		int randomNumber = numberContainer.getRandomNumber();
		for(Car car : cars) {
			car.move(randomNumber);
		}
	}
}
