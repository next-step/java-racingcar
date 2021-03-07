package calculator;

import java.util.Scanner;

public class CalculatorApplication {
	private static boolean isContinued = true;

	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		while (isContinued) {
			executeCalculator(calculator);
		}
	}

	private static void executeCalculator(Calculator calculator) {
		print("계산식을 넣어주세요. 연산 기호와 숫자 사이에는 반드시 공백이 있어야 합니다. 종료하려면 exit를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();

		if (expression.equals("exit")) {
			isContinued = false;
			print(("계산기가 종료 되었습니다."));
			return;
		}

		try {
			String[] splitData = calculator.splitNumberAndOperator(expression);
			int result = calculator.calculate(splitData);
			print("결과 : " + result);
		} catch (IllegalArgumentException ex) {
			print("잘못된 값이 입력 되었습니다.");
		} catch (Exception ex) {
			isContinued = false;
			print("알 수 없는 오류가 발생하여 프로그램을 종료합니다.");
		}
	}

	private static void print(String text) {
		System.out.println(text);
	}

}
