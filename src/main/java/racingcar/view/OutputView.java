package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

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

	public void printWinners(StringJoiner stringJoiner) {
		System.out.println(String.format("%s 가 최종 우승했습니다", stringJoiner));
	}
}
