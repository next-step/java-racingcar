package study;

import java.util.List;

public class ResultView {

	public void getResultComment() {
		System.out.println("실행 결과");
	}

	public void viewResult(List<Car> carList) {
		for(Car car : carList) {
			System.out.println(car.getDistance());
		}
		System.out.println();
	}
}
