import calculator.Calculator;

import java.io.IOException;
import java.util.Scanner;

public class CalcualtionRunner {

	public static void main(String args[]) {

		String expression;
		Scanner scan = new Scanner(System.in);

		while (true){

			System.out.println("계산 할 수식을 입력하세요: (종료 -1)");

			expression = scan.nextLine();            // 키보드 문자 입력
			if(expression.equals("-1")){
				break;
			}

			System.out.println(new Calculator(expression).execute());
		}
	}
}
