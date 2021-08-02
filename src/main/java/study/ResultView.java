package study;

import java.util.List;

public class ResultView {

	public void getResultComment() {
		System.out.println("실행 결과");
	}

	public void viewResult(List<Car> carList) {
		for(Car car : carList) {
			carResult(car);
			System.out.println();
		}
		System.out.println();
	}

	private String carResult(Car car) {
		for(int i = 1 ; i <= car.getDistance(); i++) {
			System.out.print("-");
		}
	}
}
