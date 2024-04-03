package racingcar.view;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import racingcar.domain.Car;

public class InputView {
	Scanner scanner = new Scanner(System.in);

	public String setCarNames() {
		System.out.println("Enter the names of the cars(separated by ,)");
		return scanner.next();
	}

	public int setTrialNumber() {
		System.out.println("How many trials?");
		int trialNumber = scanner.nextInt();
		System.out.println("Result");
		return trialNumber;
	}
}
