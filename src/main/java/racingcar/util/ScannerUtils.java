package racingcar.util;

import java.util.Scanner;

import racingcar.exception.UtilCreationException;

public final class ScannerUtils {
	private ScannerUtils() {
		throw new UtilCreationException();
	}

	public static int scanInt() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static String scanString() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
