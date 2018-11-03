package racinggame;

import java.util.Scanner;

public class InputView {

	private Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int inputNumber(String print) {
		System.out.println(print);
		return scanner.nextInt();
	}
}
