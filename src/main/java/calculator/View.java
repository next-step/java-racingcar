package calculator;

import java.util.Scanner;

/**
 * @author : byungkyu
 * @date : 2020/12/02
 * @description : UI
 **/
public class View {
	private static final Scanner scanner = new Scanner(System.in);

	public static String input() {
		return scanner.nextLine();
	}

	public static void printResult(int arg) {
		System.out.println(arg);
	}
}
