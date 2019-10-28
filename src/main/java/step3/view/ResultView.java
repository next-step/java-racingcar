package step3.view;

import step3.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
	private int time;

	public ResultView(int time) {
		this.time = time;
	}

	public void showResult(List<Car> carList) {
		for (int i = 0; i <= time; i++) {
			showPosition(carList, i);
		}

		showWinner(carList);
	}

	private void showPosition(List<Car> carList, int positionIndex) {
		for (Car car : carList) {
			printPosition(car.getName(), car.getPositionList().get(positionIndex));
		}
		System.out.println();
	}

	private void printPosition(String name, int pos) {
		System.out.print(name + " : ");
		for (int i = 0; i <= pos; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void showWinner(List<Car> carList) {
		List<String> winnerNameList = new ArrayList<>();
		for (Car car : carList) {
			if (car.getIsWinner()) winnerNameList.add(car.getName());
		}
		System.out.println(String.join(",", winnerNameList) + "가 최종 우승했습니다.");
	}
}
