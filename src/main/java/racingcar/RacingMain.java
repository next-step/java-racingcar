package racingcar;

import java.util.Scanner;

import racingcar.domain.RacingCars;

public class RacingMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RacingCars racingCars = new RacingCars();

		System.out.println("Enter the names of the cars(separated by ,)");
		String carNames = scanner.next();

		System.out.println("How many trials?");
		int trialNumber = scanner.nextInt();
		System.out.println("Result");

		racingCars.addCarsToList(carNames);
		racingCars.conductCarRacing(trialNumber);
		racingCars.getWinners();

	}
}
