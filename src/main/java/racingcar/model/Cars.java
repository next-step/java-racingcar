package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.Main;
import racingcar.util.Input;

public final class Cars {
	private static List<Car> cars;

	public Cars() {
		cars = new ArrayList<>();
	}

	public Cars(final List<Car> cars) {
		Cars.cars = cars;
	}

	public int size() {
		return cars.size();
	}

	public void createCar(final Car car) {
		cars.add(car);
	}

	public Car car(final Integer num) {
		return cars.get(num);
	}

	public List<Car> cars() {
		return cars;
	}

	public List<Car> createCars(final List<String> carNames) {
		for (int carNum = 0; carNum < carNames.size(); carNum++) {
			limitNameLegth(carNames, carNum);
			Input.validateInput(carNames.get(carNum));
			Car car = new Car(carNames.get(carNum).trim());
			createCar(car);
		}
		return cars;
	}

	private void limitNameLegth(final List<String> carNames, final Integer carNum) {
		if (carNames.get(carNum).trim().length() > 5) {
			String[] args = new String[0];
			Main.main(args);
		}
	}
}
