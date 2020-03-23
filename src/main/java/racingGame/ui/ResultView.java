package racingGame.ui;

import racingGame.domain.Car;

import java.util.List;

public class ResultView {
	private static final String RESULT_MSG = "실행 결과";
	private static final String WINNER_MSG = "가 최종 우승했습니다.";

	public void printResultStart() {
		System.out.println(RESULT_MSG);
	}

	public void printResult(List<Car> cars) {
		cars.forEach(car -> {
			System.out.print(car.getRacer());
			System.out.print(" : ");
			System.out.println(getCarMarkerString(car.getDistance()));
		});
	}

	private String getCarMarkerString(int car) {
		StringBuilder carMarker = new StringBuilder();
		for (int j = 0; j < car; j++) {
			carMarker.append("-");
		}
		return carMarker.toString();
	}

	public void printWinner(List<String> winners) {
		System.out.println(String.join(", ", winners) + WINNER_MSG);
	}
}
