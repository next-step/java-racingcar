package racinggame.view;

import racinggame.model.Cars;
import racinggame.util.StringUtil;

public class ResultView {
	public static void resultView(Cars cars) {
		cars.getCarsStatus()
				.stream()
				.map(i -> StringUtil.getCarRacingPrint(i))
				.forEach(System.out::println);
	}
}
