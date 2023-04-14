package step3_racingcar.view;

import java.util.List;

import step3_racingcar.domain.Car;

public class ResultView {

	private static void printCarStatus(List<Car> cars) {
		System.out.println();
		for (Car car : cars) {
			System.out.println(car.getStatus());
		}
	}

	public void printResult(List<List<Car>> results) {
		for (List<Car> roundResult : results) {
			printCarStatus(roundResult);
		}
	}
}
