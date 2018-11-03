package racinggame;

import java.util.List;

/**
 * Created by hspark on 03/11/2018.
 */
public class ResultView {
	public static void output(List<CarDTO> cars) {
		for (CarDTO car : cars) {
			printCar(car);
		}
		System.out.println();
	}

	private static void printCar(CarDTO car) {
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
