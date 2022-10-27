package racing.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import racing.domain.Count;

public class InputView {

	private static final String COMMA_DELIMETER = ",";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public InputView() {
		this(new Scanner(System.in));
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

	public List<String> askCarNamesQuestion(String question) {
		print(question);

		String inputString = scanner.nextLine();

		String[] splitedStrings = inputString.split(COMMA_DELIMETER);

		return Arrays.stream(splitedStrings)
			.collect(Collectors.toList());
	}

	public void print(String text) {
		System.out.println(text);
	}
}
