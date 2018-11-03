package racinggame;

import java.util.Scanner;

/**
 * Created by hspark on 03/11/2018.
 */
public class InputView {
	public static int input(InputType inputType) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(inputType.getComment());
		return scanner.nextInt();
	}
}
