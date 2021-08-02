package study;

import java.util.List;

public class Stadium {

	private NumberContainer numberContainer;

	public Stadium(NumberContainer numberContainer) {
		this.numberContainer = numberContainer;
	}

	public void startRace(List<Car> carList) {
		int randomNumber = numberContainer.getRandomNumber();
		for(Car car : carList) {
			car.move(randomNumber);
		}
	}
}
