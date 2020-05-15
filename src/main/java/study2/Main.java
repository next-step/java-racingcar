package study2;

import java.util.Scanner;

import study2.Operator;

public class Main {
	 CheckStringOrOpearator check = new CheckStringOrOpearator();
	 Calculator cal = new Calculator();

	 public void main(String[] args) {

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

class Calculator {
	CheckStringOrOpearator check = new CheckStringOrOpearator();
	Operator op = new Operator();
	
	public int calculate(String[] str) {
		int result = 0; // 결과 저장
			
		for (int i = 0; i < str.length - 1; i += 2) {
			int sum = 0;
			check.notOperator(str[i + 1]); // 연산자 check
						
			if (str[i + 1].equals(Operator.ADD)) {
				sum = op.add(Integer.parseInt(str[i]), Integer.parseInt(str[i + 2]));
				str[i + 2] = Integer.toString(sum);
			}

			if (str[i + 1].equals(Operator.SUB)) {
				sum = op.sub(Integer.parseInt(str[i]), Integer.parseInt(str[i + 2]));
				str[i + 2] = Integer.toString(sum);
			}

			if (str[i + 1].equals(Operator.MULTI)) {
				sum = op.multi(Integer.parseInt(str[i]), Integer.parseInt(str[i + 2]));
				str[i + 2] = Integer.toString(sum);
			}
			if (str[i + 1].equals(Operator.DIV)) {
				sum = op.divide(Integer.parseInt(str[i]), Integer.parseInt(str[i + 2]));
				str[i + 2] = Integer.toString(sum);
			}
			result = Integer.parseInt(str[i + 2]);
		}
		System.out.println("연산 결과는 :  " + result);
		return result;
	}
}
