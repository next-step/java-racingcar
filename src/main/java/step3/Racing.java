package step3;

import java.util.Random;
import java.util.Scanner;

public class Racing {
	private Print print = new Print();
	private Scanner sc = new Scanner(System.in);

	public static int random() {
		Random random = new Random();
		return random.nextInt(10);
	}

	public static String movingCount(int input) {
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

		racingStart(Cars.participant(cars), Cars.move(moveCount));
	}

	private void racingStart(int participant, int movingCount) {
		move(participant, movingCount, initialize(participant));
	}

	private void move(int participant, int move, String[] cars) {
		for (int i = 0; i < move; i++) {
			for (int j = 0; j < participant; j++) {
				cars[j] += movingCount(random());
				print.print(cars[j]);
			}
			print.newLine();
		}
	}

	private String[] initialize(int participant) {
		String[] cars = new String[participant];
		for (int i = 0; i < participant; i++) {
			cars[i] = "";
		}
		return cars;
	}
}
