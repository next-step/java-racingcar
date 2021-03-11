package im.juniq.racingcar;

import java.util.List;

public class ResultView {
	public static void printCarMoveCount(List<RacingCar> cars) {
		for (RacingCar racingCar: cars) {
			printCarMoveCount(racingCar);
		}
		System.out.println();
	}

	public static void printCarMoveCount(RacingCar car) {
		for (int i = 0; i < car.getMoveCount(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
