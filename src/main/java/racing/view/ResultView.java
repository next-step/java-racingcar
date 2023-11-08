package racing.view;

import racing.car.Car;
import racing.car.CarList;

import java.util.List;

public class ResultView {

	public ResultView() {
		System.out.println("실행 결과");
	}

	public void print(CarList carList) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < carList.getNumberOfCars(); i++) {
			toString(carList.get(i), result);
		}
		System.out.println(result);
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

	private static void toString(Car car, StringBuilder result) {
		int position = car.getPosition();
		result.append(car.getName()).append(" : ");
		for (int i = 0; i < position; i++) {
			result.append("-");
		}
		result.append("\n");
	}

}
