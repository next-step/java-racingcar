package step1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Parser parser = new Parser(insertUserInput());
			SequentialCalculator calculator = new SequentialCalculator(parser.getNumbers(), parser.getOperators());
			System.out.println(String.format("결과는 %s 입니다", calculator.getResult().toPlainString()));
		} catch (IllegalArgumentException e) {
			System.out.println(String.format("입력한 문자열을 확인해 주세요! Error message: %s", e.getMessage()));
		} catch (ArithmeticException e) {
			System.out.println("혹시 0으로 나누셨나요?");
		}
	}

	private static String insertUserInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
