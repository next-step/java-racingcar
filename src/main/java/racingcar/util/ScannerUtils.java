package racingcar.util;

import java.util.Scanner;

public final class ScannerUtils {
	private ScannerUtils() {
	}

	public static int scanInt() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
