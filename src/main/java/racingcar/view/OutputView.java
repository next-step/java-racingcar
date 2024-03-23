package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	private static final String DASH = "-";

	public void moveCars(List<Car> carList) {
		for (Car car : carList) {
			int moveDistance = car.getPosition();
			System.out.println(DASH.repeat(moveDistance));
		}
		System.out.println("");
	}
}
