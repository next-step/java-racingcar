package step3;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("자동차 대수는 몇 대 인가요?");
		int carCount = scanner.nextInt();
		System.out.println("시도할 횟수는 몇 회 인가요?");
		int times = scanner.nextInt();

	}

	public static boolean canMoveForward(int randomNumber) {
		return randomNumber >= 4;
	}
}
