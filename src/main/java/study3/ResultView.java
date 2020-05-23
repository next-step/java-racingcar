package study3;

import java.util.Arrays;
import java.util.List;

public class ResultView {

	private static String mov = "-";

	public ResultView() {
		outputMessages();

	}

	public void outputMessages() {
		System.out.println("실행결과");
	}

	public void outputResult(List<Car> carList) {
		for (Car car : carList) {
			outputnumCarResult(car);
		}
		System.out.println();
	}

	public void outputnumCarResult(Car car) {
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print(mov);
		}
		System.out.println();
	}

}
