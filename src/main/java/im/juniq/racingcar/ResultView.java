package im.juniq.racingcar;

import java.util.List;

public class ResultView {
	public void printCarsStatus(List<Car> cars) {
		for (Car car : cars) {
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

	public void printWinner(List<Car> winners) {
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
