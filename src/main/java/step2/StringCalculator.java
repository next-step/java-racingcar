package step2;

import java.util.Scanner;
import java.util.Stack;

public class StringCalculator {
	private static final String ONLY_NUMBER = "^[0-9]+$";

	public String getResult(String str) {
		if(this.isEmpty(str)) {
			throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자");
		}

		String[] values = str.split(" ");
		Stack<String> expression = new Stack<>();
		for(String value : values) {
			expression.push(value);
			if(value.matches(ONLY_NUMBER) && expression.size() == 3) {
				expression.push(this.calculate(Integer.parseInt(expression.pop()), expression.pop(), Integer.parseInt(expression.pop())));
			}
		}
		return expression.pop();
	}

	public String calculate(int num2, String op, int num1) {
		if("+".equals(op)) {
			return this.addition(num1, num2);
		}
		if("-".equals(op)) {
			return this.subtraction(num1, num2);
		}
		if("*".equals(op)) {
			return this.multiplication(num1, num2);
		}
		if("/".equals(op)) {
			return this.division(num1, num2);
		}
		throw new IllegalArgumentException("사칙연산 연산자 오입력");

	}

	public boolean isEmpty(String str) {
		return null == str || str.length() == 0 || str.matches("^\\s*$");
	}

	public String addition(int num1, int num2) {
		return Integer.toString(num1 + num2);
	}

	public String subtraction(int num1, int num2) {
		return Integer.toString(num1 - num2);
	}

	public String multiplication(int num1, int num2) {
		return Integer.toString(num1*num2);
	}

	public String division(int num1, int num2) {
		if(num2 == 0) {
			throw new ArithmeticException("나눗셈 식의 분모는 0이 될 수 없습니다.");
		}
		return Integer.toString(num1/num2);
	}

}
