package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	private static final String DASH = "-";

	public void moveCars(List<Car> carList) {
		for (Car car : carList) {
			int moveDistance = car.getPosition();
			System.out.print(car.name() + " : ");
			System.out.println(DASH.repeat(moveDistance));
		}
		System.out.println("");
	}

	public void printWinners(String winners) {
		System.out.printf("%s 가 최종 우승했습니다%n", winners);
	}
}
