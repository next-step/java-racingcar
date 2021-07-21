package racing.service;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

	private List<Car> cars = new ArrayList<>();
	private int repeatCount = 0;
	public CarService(int carCount, int repeatCount) {
		for (int i = 0; i < carCount; i++) {
			this.cars.add(new Car());
		}
		this.repeatCount = repeatCount;
	}

	public int carsCount() {
		return cars.size();
	}

	public int getRepeatCount() {
		return repeatCount;
	}



}
