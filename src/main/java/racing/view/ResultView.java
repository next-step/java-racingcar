package racing.view;

import racing.car.Car;
import racing.car.CarList;

import java.util.List;

public class ResultView {

	public ResultView() {
		System.out.println("실행 결과");
	}

	public void print(CarList carList) {
		int numberOfCars = carList.getNumberOfCars();
		for (int i = 0; i < numberOfCars; i++) {
			System.out.println(carList.getStatus(i));
		}
		System.out.println();
	}

	public void printWinners(List<String> winners) {
		StringBuilder result = new StringBuilder();
		for (String winner : winners) {
			result.append(winner).append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("가 최종 우승했습니다.");
		System.out.println(result);
	}

}
