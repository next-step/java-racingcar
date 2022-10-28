package racing.view;

import static java.lang.System.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import racing.CarNamesDto;
import racing.domain.Count;

public class InputView {

	private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String COMMA_DELIMETER = ",";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public InputView() {
		this(new Scanner(in));
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

	public CarNamesDto askCarNames() {
		print(CAR_NAME_QUESTION);

		String inputString = scanner.nextLine();

		List<String> splitedStrings = Arrays.stream(inputString.split(COMMA_DELIMETER))
			.collect(Collectors.toList());

		return CarNamesDto.of(splitedStrings);
	}

	private void print(String text) {
		out.println(text);
	}
}
