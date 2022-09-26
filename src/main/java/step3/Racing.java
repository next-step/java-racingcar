package step3;

import java.util.Random;
import java.util.Scanner;

public class Racing {
	private static final int MOVECONDITION = 4;
	private static final Scanner sc = new Scanner(System.in);

	public static void playRace() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		String participant = sc.nextLine();
		System.out.println("시도할 회수는 몇 회 인가요?");
		String matches = sc.nextLine();

		result(checkInput(participant), checkInput(matches));
	}

	private static void result(String participant, String matches) {
		Cars cars = participate(participant);
		playMatches(cars, matches);
	}

	private static void playMatches(Cars cars, String matches) {
		for (int i = 0; i < Integer.parseInt(matches); i++) {
			for (int j = 0; j < cars.cars.size(); j++) {
				int rand = new Random().nextInt(10);
				cars.cars.get(j).move(move(rand));
				System.out.println(cars.cars.get(j).getStatus());
			}
			System.out.println();
		}
	}

	public static Cars participate(String input) {
		int participant = Integer.parseInt(checkInput(input));
		return new Cars(participant);
	}

	public static String checkInput(String input) {
		if (validateMinus(input) || validateCharacter(input)) {
			throw new RuntimeException();
		}
		return input;
	}

	private static boolean validateMinus(String input) {
		return Integer.parseInt(input) < 0;
	}

	private static boolean validateCharacter(String input) {
		return 89 < input.charAt(0) && input.charAt(0) < 80;
	}

	public static String move(int input) {
		if (MOVECONDITION <= input) {
			return "-";
		}
		return "";
	}
}
