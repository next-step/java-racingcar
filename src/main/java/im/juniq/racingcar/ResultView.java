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
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
