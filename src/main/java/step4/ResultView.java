package step4;

import java.util.List;

public class ResultView  {

	public void getResultComment() {
		System.out.println("실행 결과");
	}

	public void viewResult(List<Car> cars) {
		for(Car car : cars) {
			carResult(car);
			System.out.println();
		}
		System.out.println();
	}

	public void winnerResult(List<Car> winners) {
		for(Car winner : winners) {
			System.out.print(winner.getCarName() + " ");
		}
	}

	private void carResult(Car car) {
		System.out.print(car.getCarName() + " : ");
		for(int i = 1 ; i <= car.getDistance(); i++) {
			System.out.print("-");
		}
	}
}
