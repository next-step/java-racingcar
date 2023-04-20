package step5_racingcar_refactoring.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step5_racingcar_refactoring.domain.Car;
import step5_racingcar_refactoring.domain.Cars;
import step5_racingcar_refactoring.service.Winner;

public class ResultView {
	private static final String lastWinnerBanner = "가 최종 우승했습니다.";

	public void printResult(List<Cars> results) {
		Winner winner = new Winner();
		for (Cars roundResult : results) {
			printCarStatus(roundResult);
			winner.findWinners(roundResult);
		}
		System.out.println(printWinner(winner));
	}

	private void printCarStatus(Cars cars) {
		System.out.println();
		for (Car car : cars.getCars()) {
			System.out.println(formatStatus(car));
		}
	}

	public String formatStatus(Car car) {
		StringBuilder status = new StringBuilder();
		status.append(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			status.append("-");
		}
		return status.toString();
	}

	private String printWinner(Winner winner) {
		System.out.println();
		StringBuilder winnerBanner = new StringBuilder();
		winnerBanner.append(printWinnerNames(winner) + lastWinnerBanner);
		return winnerBanner.toString();
	}

	public String printWinnerNames(Winner winner) {
		String winners = String.join(", ", winner.getNames());

		return winners;
	}
}
