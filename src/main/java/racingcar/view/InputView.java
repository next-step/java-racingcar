package racingcar.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import racingcar.domain.Car;

public class InputView {
	Scanner scanner = new Scanner(System.in);

	public int inputCarNumber(List<Car> carList) {
		System.out.println("How many cars?");
		return scanner.nextInt();
	}

	public int inputTrialNumber() {
		System.out.println("How many trials?");
		return scanner.nextInt();
	}

}
