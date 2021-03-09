package racingcar;

import java.util.Scanner;

public class InputView {
	private String text;

	public void setText(String text) {
		this.text = text;
	}

	public int getScanner() {
		System.out.println(text);
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return Integer.valueOf(input);
	}
}
