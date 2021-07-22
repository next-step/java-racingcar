package racingwinner.ui;

import racingwinner.domain.Car;

import java.util.List;

public class ResultView {

	private static final String MOVE_SIGN = "-";

	public void result(List<Car> cars) {
		for (Car car : cars) {
			print(car);
		}
		System.out.println();
	}

	private void print(Car car) {
		StringBuilder totalSign = new StringBuilder();
		totalSign.append(car.getName())
		         .append(" : ");
		for (int i = 0; i < car.getForwardCount(); i++) {
			totalSign.append(MOVE_SIGN);
		}
		System.out.println(totalSign);
	}

}
