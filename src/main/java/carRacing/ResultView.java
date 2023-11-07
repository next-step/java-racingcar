package carRacing;

import java.util.List;

public class ResultView {

	public void showResult(List<Car> cars) {
		for (Car car : cars) {
			car.moveCar();
			System.out.println("-".repeat(car.index));
		}
		System.out.println();
	}
}
