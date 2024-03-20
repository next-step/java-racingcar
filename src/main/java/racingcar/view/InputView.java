package racingcar.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import racingcar.domain.Car;

public class InputView {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	public String[] inputCarNumber(List<Car> carList) {
		System.out.println("Enter the names of the cars(separated by ,)");
		String carName = scanner.next();
		String[] carNameList = carName.split(",");
		for (int i = 0; i < carNameList.length; i++) {
			Car car = new Car();
			carList.add(car);
		}
		return carNameList;
	}

	public int inputTrialNumber() {
		System.out.println("How many trials?");
		return scanner.nextInt();
	}

	public void moveCars(List<Car> carList) {
		for (Car car : carList) {
			int randomNum = random.nextInt(10);
			car.moveForward(randomNum);
		}
	}
}
