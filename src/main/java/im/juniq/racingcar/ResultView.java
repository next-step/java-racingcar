package im.juniq.racingcar;

import java.util.List;

public class ResultView {
	private List<Car> cars;

	public ResultView(List<Car> cars) {
		this.cars = cars;
	}

	public void printCarMoveCount() {
		for (Car car : cars) {
			printCarMoveCount(car);
		}
		System.out.println();
	}

	private void printCarMoveCount(Car car) {
		for (int i = 0; i < car.getMoveCount(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
