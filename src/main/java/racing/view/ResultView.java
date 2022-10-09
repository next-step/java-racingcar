package racing.view;

import racing.domain.Car;
import racing.domain.RacingCars;

public class ResultView {

	public ResultView() {
	}

	public void printCarStatuses(RacingCars racingCars) {
		for (int i = 0; i < racingCars.getRacingCars().size(); i++) {
			printCarName(racingCars.getRacingCars().get(i));
			printCarLocation(racingCars.getRacingCars().get(i));
		}
	}

	private void printCarName(Car car) {
		System.out.print(car.getName() + " : ");
	}

	private void printCarLocation(Car car) {
		for (int i = 0; i < car.getLocation(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
