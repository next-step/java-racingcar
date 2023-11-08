package carRacing;

import java.util.List;

public class ResultView {

	public static final String HYPHEN = "-";

	public void showResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(HYPHEN.repeat(car.getPosition()));
		}
		System.out.println();
	}
}
