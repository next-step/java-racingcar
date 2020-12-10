package stringcalculator;

import java.io.IOException;
import java.util.Scanner;

public class CalculatorStarter {
	public static void main(String[] args) throws IOException {
		OperatorFactory.init();
		System.out.println("계산하고 싶은 식을 입력해주세요. (e.g. 1 + 3 * 4 / 2)");
		Scanner sc = new Scanner(System.in);
		Calculator calculator = new Calculator();
		System.out.println(calculator.calculate(sc.nextLine()));
	}
}
