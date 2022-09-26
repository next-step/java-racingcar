package step3;

public class Racing {
	public static int participate(String input) {
		return Integer.parseInt(input);
	}

	public static void checkInput(String input) {
		if (Integer.parseInt(input) < 0 || validateCharacter(input)) {
			throw new RuntimeException();
		}
	}

	private static boolean validateCharacter(String input) {
		return 89 < input.charAt(0) && input.charAt(0) < 80;
	}
}
