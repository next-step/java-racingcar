package step3;

import java.util.Random;
import java.util.Scanner;

public class Racing {
	private static Print print = new Print();
	private static Scanner sc = new Scanner(System.in);

	private static int ADVANCE_CONDITION = 4;

	public static int participant(String input) {
		return Integer.parseInt(input);
	}

	public static int move(String input) {
		return Integer.parseInt(input);
	}

	public static int random() {
		Random random = new Random();
		return random.nextInt(10);
	}

	public static String movingCount(int input) {
		if (ADVANCE_CONDITION <= input) {
			return "-";
		}
		return "";
	}

	public void play() {
		print.howManyCars();
		String cars = sc.nextLine();
		print.howManyMovingCount();
		String moveCount = sc.nextLine();

		racingStart(participant(cars), move(moveCount));
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
