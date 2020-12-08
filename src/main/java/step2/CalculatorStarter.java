package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorStarter {
	public static void main(String[] args) throws IOException {
		OperatorFactory.init();
		System.out.println("계산하고 싶은 식을 입력해주세요. (e.g. 1 + 3 * 4 / 2)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calculator calculator = new Calculator();
		System.out.println(calculator.calculate(br.readLine()));
	}
}
