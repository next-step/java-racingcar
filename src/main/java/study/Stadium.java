package study;

import java.util.List;

public class Stadium {

	private NumberContainer numberContainer;
	private static int RACE_WIN_RANGE = 4;

	public Stadium() {
		numberContainer = new NumberContainer();
	}

	public void startRace(List<Car> carList) {
		for(Car car : carList) {
			carRace(car);
		}
	}

	private void carRace(Car car) {
		if(getRaceResult()) {
			car.go();
			return ;
		}
		car.stop();
	}

	private boolean getRaceResult() {
		return numberContainer.getRandomNumber() >= RACE_WIN_RANGE;
	}
}
