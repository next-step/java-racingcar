package ragingwinner.ui;

import ragingwinner.domain.Car;

import java.util.List;

public class ResultView {

	private static final String MOVE_SIGN = "-";

	public void result(List<Car> cars) {
		for (Car car : cars) {
			print(car.getForwardCount());
		}
		System.out.println();
	}

	private void print(int forwardCount) {
		StringBuilder totalSign = new StringBuilder();
		for (int i = 0; i < forwardCount; i++) {
			totalSign.append(MOVE_SIGN);
		}
		System.out.println(totalSign);
	}

}
