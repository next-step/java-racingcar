package racingcar.view;

import java.io.InputStreamReader;
import java.util.Scanner;

public class InputViewCarName extends InputView<String[]> {
	private final Readable readable;

	public InputViewCarName(String text) {
		this(text, new InputStreamReader(System.in));
	}

	public InputViewCarName(String text, Readable readable) {
		super(text);
		this.readable = readable;
	}

	@Override
	public String[] getInput() {
		super.printText();
		Scanner sc = new Scanner(readable);
		String input = sc.nextLine();
		return input.split(",");
	}
}
