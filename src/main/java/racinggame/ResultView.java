package racinggame;

import java.util.List;

/**
 * Created by hspark on 03/11/2018.
 */
public class ResultView {
	public void output(List<Car> cars) {
		for (Car car : cars) {
			printCar(car);
		}
		System.out.println();
	}

	private void printCar(Car car) {
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
