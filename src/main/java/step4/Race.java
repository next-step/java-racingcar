package step4;

import java.util.List;

public class Race {
	private NumberContainer numberContainer;

	public Race(NumberContainer numberContainer) {
		this.numberContainer = numberContainer;
	}

	public void startRace(List<Car> cars) {
		for(Car car : cars) {
			int randomNumber = numberContainer.getRandomNumber();
			car.move(randomNumber);
		}
	}
}
