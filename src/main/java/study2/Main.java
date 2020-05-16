package study2;

import java.util.Scanner;

import study2.Operator;

public class Main {
	 static CheckStringOrOpearator check = new CheckStringOrOpearator();
	 static Calculator cal = new Calculator();

	 public static void main(String[] args) {

		System.out.println(" 연산식을 입력하시오 ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		check.allOperatorIncludeCheck(input); // 모든 연산자 포함하는지 check
	
		String[] stringArr = input.split(" ");
		 
		check.inspectNullCheck(input); // 공백 or null check
		
		cal.calculate(stringArr); // 연산 start
	}
}

