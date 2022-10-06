package racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import racing.domain.Count;

public class InputView {

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int askCountQuestion(String question) {
		print(question);

		try {
			int value = scanner.nextInt();
			Count count = new Count(value);

			return count.getCount();
		} catch (InputMismatchException exception) {
			throw new InputMismatchException("숫자를 입력해주세요.");
		}
	}

	public void print(String text) {
		System.out.println(text);
	}
}
