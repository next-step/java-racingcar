package racingcar;

import java.util.Scanner;

public class InputView {
	private String text;

	public InputView(String text) {
		this.text = text;
	}

	public int getInputNumber() {
		printText();
		String input = getInput();
		return Integer.valueOf(input);
	}

	public String[] getInputCarName() {
		printText();
		String input = getInput();
		return input.split(",");
	}

	private String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	private void printText() {
		System.out.println(this.text);
	}
}
