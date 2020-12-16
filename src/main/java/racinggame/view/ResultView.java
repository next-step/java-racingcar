package racinggame.view;

import racinggame.domain.Car;

public class ResultView {
	public void printResultText() {
		System.out.println("실행 결과");
	}

	public void printCarPosition(int position) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}

	public void printCarInfo(Car car) {
		int position = car.getPosition();
		StringBuilder sb = new StringBuilder();
		sb.append(car.getName()).append(" : ");
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}

	public void nextLine() {
		System.out.println();
	}

	public void printWinnerNames(String winnerNames) {
		System.out.println(winnerNames + "가 최종 우승했습니다.");
	}
}
