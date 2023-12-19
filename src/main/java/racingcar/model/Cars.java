package racingcar.model;

import java.util.HashMap;
import java.util.Map;

import racingcar.Main;
import racingcar.util.Input;

public class Cars {
	private Map<Integer, Car> cars;

	public Cars() {
		cars = new HashMap<>();
	}

	public int size() {
		return cars.size();
	}

	public void createCar(Integer num, Car car) {
		cars.put(num, car);
	}

	public Car car(Integer num) {
		return cars.get(num);
	}

	public Map<Integer, Car> cars() {
		return cars;
	}

	public void createCars(String[] carNames) {
		for (int carNum = 1; carNum <= carNames.length; carNum++) {
			limitNameLegth(carNames, carNum);
			Input.validateInput(carNames[carNum - 1]);
			Car car = new Car(carNames[carNum - 1].trim());
			createCar(carNum, car);
		}
	}

	private void limitNameLegth(String[] carNames, Integer carNum) {
		if (carNames[carNum - 1].trim().length() > 5) {
			String[] args = new String[0];
			Main.main(args);
		}
	}
}
