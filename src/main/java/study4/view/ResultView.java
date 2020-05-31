package study4.view;

import java.util.Arrays;
import java.util.List;

import study4.domain.Car;

public class ResultView {
	
	public ResultView() {
		System.out.println("실행결과");
	}

	public List<Car> outputResult(List<Car> carList) {
		for (Car car : carList) {
			System.out.print(car.getCarName() + " : ");
			car.outputnumCarResult(car);
		}
		System.out.println();
		
		return carList;
	}
}
