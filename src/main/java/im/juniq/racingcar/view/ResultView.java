package im.juniq.racingcar.view;

import im.juniq.racingcar.domain.Car;
import im.juniq.racingcar.domain.RacingGame;

public class ResultView {
	public void printCarsStatus(RacingGame racingGame) {
		for (Car car : racingGame) {
			printCarStatus(car);
		}
		System.out.println();
	}

	private void printCarStatus(Car car) {
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printWinner(RacingGame winners) {
		for (int i = 0; i < winners.size(); i++) {
			printSeparator(i);
			System.out.print(winners.get(i).getName());
		}
		System.out.println("가 최종 우승했습니다.");
	}

	private void printSeparator(int i) {
		if (i != 0) {
			System.out.print(", ");
		}
	}
}
