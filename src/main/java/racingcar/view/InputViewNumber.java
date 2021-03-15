package racingcar.view;

import java.util.Scanner;

public class InputViewNumber extends InputView<Integer> {

	public InputViewNumber(String text) {
		super(text);
	}

	@Override
	public Integer getInput() {
		super.printText();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return Integer.valueOf(input);
	}

}
