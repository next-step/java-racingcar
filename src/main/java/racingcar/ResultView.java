package racingcar;

import java.util.List;

public class ResultView {
	public static void outputResult(List<RacingCar> racingCars) {
		for (int i = 0 ; i < racingCars.size() ; i++) {
			for (int j = 0 ; j < racingCars.get(i).getPos() ; j++) {
				System.out.print("-");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
