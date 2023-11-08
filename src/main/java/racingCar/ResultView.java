package racingCar;

import java.util.List;

public class ResultView {
	private List<Car> carList;
	private int tryCount;
	private static String RESULT_PREFIX = "실행 결과";

	public ResultView(List<Car> carList, int tryCount) {
		this.carList = carList;
		this.tryCount = tryCount;
		resultUi();
	}

	public void resultUi() {
		System.out.println();
		System.out.println(RESULT_PREFIX);
		printFinalResult();
	}

	private void printFinalResult() {
		for (int j = 0; j < tryCount; j++) {
			printResultPerCar(j);
			System.out.println();
		}
	}

	private void printResultPerCar(int idx) {
		for (Car car : carList) {
			printRepeat(car.resultList.get(idx));
			System.out.println();
		}
	}

	private void printRepeat(int number) {
		for (int i = 0; i < number; i++) {
			System.out.print("=");
		}
	}

}
