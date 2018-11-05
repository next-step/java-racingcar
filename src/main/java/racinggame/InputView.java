package racinggame;

import java.util.Scanner;

public class InputView {

	private static Scanner scanner = new Scanner(System.in);

	public static int inputNumber(String print) {
		System.out.println(print);
		return scanner.nextInt();
	}

	public static String inputString(String print) {
		System.out.println(print);
		return scanner.nextLine();
	}
}
