package study.calculator;

import java.util.Scanner;

public class InputScanner {
	private String input;
	Scanner scanner;

	public InputScanner() {
		this.input = "";
		scanner = new Scanner(System.in);
	}

	public void scan() {
		System.out.println("사칙연산을위한 문자열을 입력하세요: ");
		validateInput(scanner.next());

	}

	public void validateInput(String next) {
		if (next == null || next.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
}
