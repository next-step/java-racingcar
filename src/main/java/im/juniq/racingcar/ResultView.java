package im.juniq.racingcar;

import java.util.List;

public class ResultView {
	public static void printCarMoveCount(List<Car> cars) {
		for (Car car : cars) {
			printCarMoveCount(car);
		}
		System.out.println();
	}

	public static void printCarMoveCount(Car car) {
		for (int i = 0; i < car.getMoveCount(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
