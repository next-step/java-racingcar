package carrase;

import java.util.List;
import java.util.Scanner;

public class CarRasingGameUI {
	private void printUncleSam() {
		System.out.println("자동차 대수는 몇 대 인가요?");
	}

	private int getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private void printGameCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
	}

	private void printResult(List<Integer> result) {
		for(int distance : result) {
			printCarMileage(distance);
		}
		System.out.println();
	}

	private void printCarMileage(int distance) {
		for(int i = 0; i < distance; i ++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void printGameStart() {
		System.out.println("실행 결과");
	}

	public void start() {
		printUncleSam();
		CarRasingGame game = new CarRasingGame(getInput());
		printGameCount();
		int count = getInput();

		printGameStart();
		for(int i = 0; i < count; i++) {
			List<Integer> result = game.start();
			printResult(result);
		}
	}
}
