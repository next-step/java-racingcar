package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.Main;
import racingcar.util.Input;

public class Cars {
	private static List<Car> cars;

	public Cars() {
		cars = new ArrayList<>();
	}

	public int size() {
		return cars.size();
	}

	public static void createCar(Car car) {
		cars.add(car);
	}

	public Car car(Integer num) {
		return cars.get(num);
	}

	public List<Car> cars() {
		return cars;
	}

	public static List<Car> createCars(List<String> carNames) {
		for (int carNum = 0; carNum < carNames.size(); carNum++) {
			limitNameLegth(carNames, carNum);
			Input.validateInput(carNames.get(carNum));
			Car car = new Car(carNames.get(carNum).trim());
			createCar(car);
		}
		return cars;
	}

	private static void limitNameLegth(List<String> carNames, Integer carNum) {
		if (carNames.get(carNum).trim().length() > 5) {
			String[] args = new String[0];
			Main.main(args);
		}
	}
}
