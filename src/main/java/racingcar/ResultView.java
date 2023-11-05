package racingcar;

import java.util.List;

public class ResultView {
	public void showResult(List<Round> rounds) {
		for (Round round : rounds) {
			for (Car car : round.getCars()) {
				System.out.println("-".repeat(car.getLocation()));
			}
			System.out.println("");
		}
	}
}
