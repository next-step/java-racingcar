package step3;

import java.util.Random;

public class RacingCarClass {
	public static void main(String arg[]) {
		int carNumber = InputView.inputCarNumber();
		int chanceNumber = InputView.inputChanceNumber();

		int[] carStatus = new int[carNumber];

		for (int i = 0; i < chanceNumber; i++) {
			singleStepRacing(carNumber, carStatus);
			ResultView.printStatus(carStatus);
		}
	}

	private static void singleStepRacing(int carNumber, int[] carStatus) {
		for (int j = 0; j < carNumber; j++) {
			if (isCarMove(getRandNumber()))
				carStatus[j]++;
		}
	}

	private static int getRandNumber() {
		Random rand = new Random();
		return rand.nextInt(10);
	}

	public static boolean isCarMove(int i) {
		if (i >= 4 && i < 10) return true;
		return false;
	}

}
