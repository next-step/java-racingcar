package racingcar.view;

import java.util.List;

import racingcar.car.Car;

public class ResultView {

	public void printResultTitle() {
		System.out.println("실행결과");
	}

	public void printCars(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			drawPosition(car.getPosition());
		}
		System.out.println();
	}

	public void printWinners(List<String> winners) {
		String result = String.join(", ", winners);
		System.out.println(result + "가 최종 우승했습니다.");
	}

	private static void drawPosition(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
