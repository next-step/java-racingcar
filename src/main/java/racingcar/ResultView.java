package racingcar;

import java.util.List;

public class ResultView {
	public void showResult(List<Round> rounds) {
		for (Round round : rounds) {
			showProgressByCar(round.getCars());
			System.out.println("");
		}
	}

	private void showProgressByCar(List<Car> cars) {
		for (Car car : cars) {
			System.out.println("-".repeat(car.getLocation()));
		}
	}
}
