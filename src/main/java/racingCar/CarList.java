package racingCar;

import racingCar.ui.ResultView;

import java.util.List;

public class CarList {
	private final List<Car> carList;

	public CarList(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> getCarList(){
		return carList;
	}

	public void addCar(int carCount) {
		for (int i = 0; i < carCount; i++) {
			carList.add(new Car());
		}
	}

	public void moveByTryCount(int tryCount) {
		for (int j = 0; j < tryCount; j++) {
			movePerCar();
			ResultView.printDistance(carList);
		}
	}

	private void movePerCar() {
		for (Car car : carList) {
			car.move();
		}
	}
}
