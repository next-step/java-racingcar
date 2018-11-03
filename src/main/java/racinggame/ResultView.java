package racinggame;

import java.util.List;
import racinggame.domain.Car;

public class ResultView {

	public ResultView() {
		System.out.println("실행 결과");
	}

	public void print(List<Car> cars) {
		for(Car car : cars) {
			System.out.println(makeOutputPosition(car));
		}
		System.out.println();
	}

	private String makeOutputPosition(Car car) {
		StringBuilder outputPosition = new StringBuilder();
		for(int i = 0; i < car.getCurrentPosition(); i++) {
			outputPosition.append("-");
		}
		return outputPosition.toString();
	}
}
