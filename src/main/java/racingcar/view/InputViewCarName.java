package racingcar.view;

import java.util.Scanner;

public class InputViewCarName extends InputView<String[]> {

	public InputViewCarName(String text) {
		super(text);
	}

	@Override
	public String[] getInput() {
		super.printText();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input.split(",");
	}
}
