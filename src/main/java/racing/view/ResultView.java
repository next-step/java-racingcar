package racing.view;

import racing.model.Car;

import java.util.List;

public class ResultView {
	public void printResult(List<Car> carList){
		System.out.println("Ready.. Go!");
		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);
			print(car.getForwardCount());
		}
		System.out.println("End!");
	}

	public void print(int forwardCount){
		for (int i = 0; i < forwardCount; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
