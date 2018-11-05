package racinggame.view;

import java.util.Scanner;

/**
 * Created by hspark on 03/11/2018.
 */
public class InputView {
	public static int inputInt(InputMessageType messageType) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(messageType.getMessage());
		return scanner.nextInt();
	}
	public static String inputString(InputMessageType messageType){
		Scanner scanner = new Scanner(System.in);
		System.out.println(messageType.getMessage());
		return scanner.nextLine();
	}
}
