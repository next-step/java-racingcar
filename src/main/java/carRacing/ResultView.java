package carRacing;

import java.util.List;

public class ResultView {

	private static final String HYPHEN = "-";
	private static final String COLON = ":";

	public void showResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + COLON +HYPHEN.repeat(car.getPosition()));
		}
		System.out.println();
	}
}
