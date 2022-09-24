package step3;

import java.util.Scanner;

public class Racing {
	private Print print = new Print();
	private Scanner sc = new Scanner(System.in);

	public static int random() {
		int random = (int)(Math.random()*10);
		return random;
	}

	public static String move(int input) {
		if (4 <= input) {
			return "-";
		}
		return "";
	}

	public void play() {
		print.howManyCars();
		String cars = sc.nextLine();
		print.howManyMovingCount();
		String moveCount = sc.nextLine();

		Cars.participant(cars);
		Cars.move(moveCount);
	}
}
