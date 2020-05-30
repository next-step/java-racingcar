package study4;

import java.util.Arrays;
import java.util.List;

public class ResultView {
	
	Car car = new Car();
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
