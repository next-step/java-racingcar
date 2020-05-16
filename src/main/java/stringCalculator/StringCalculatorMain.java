package stringCalculator;

import java.util.Scanner;

import stringCalculator.domain.StringCalculator;

public class StringCalculatorMain {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("연산식을 입력하세요 : ");
		
		StringCalculator calculator = new StringCalculator();
		int result = calculator.stringCalculate(scanner.nextLine());
		
		System.out.println("연산 결과는 " + result + "입니다.");
	}
}
