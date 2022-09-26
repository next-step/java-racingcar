package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Racing {
	private static final int MOVECONDITION = 4;
	private static final Scanner sc = new Scanner(System.in);

	public static void playRace() {
		Print.howManyCars();
		String participant = sc.nextLine();
		Print.howManyMatches();
		String matches = sc.nextLine();

		result(checkInput(participant), checkInput(matches));
	}

	private static void result(String participant, String matches) {
		Cars cars = participate(participant);
		playMatches(cars, matches);
	}

	private static void playMatches(Cars cars, String matches) {
		for (int i = 0; i < Integer.parseInt(matches); i++) {
			playMatch(cars);
		}
	}

	private static void playMatch(Cars cars) {
		for (int i = 0; i < cars.getCars().size(); i++) {
			int rand = new Random().nextInt(10);
			cars.getCars().get(i).move(move(rand));
			Print.resultOfRound(cars.getCars().get(i).getStatus());
		}
		Print.newLine();
	}

	public static Cars participate(String input) {
		List<Car> cars = new ArrayList<>();
		int participant = Integer.parseInt(checkInput(input));
		for (int i = 0; i < participant; i++) {
			cars.add(new Car());
		}
		return new Cars(cars);
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
