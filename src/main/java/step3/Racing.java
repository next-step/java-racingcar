package step3;

import java.util.List;

public class Racing {
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
		if (4 <= input) {
			return "-";
		}
		return "";
	}
}
