package racing.view;

import racing.car.Car;
import racing.car.CarList;

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

	private static void toString(Car car, StringBuilder result) {
		int position = car.getPosition();
		for (int i = 0; i < position; i++) {
			result.append("-");
		}
		result.append("\n");
	}

}
