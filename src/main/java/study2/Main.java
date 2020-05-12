package study2;

import java.util.Scanner;

import study2.Operator;

public class Main {
	
	public static void main(String[] args) {
		
		NullorBlankString nullcheck = new NullorBlankString();
		
		Operator op = new Operator();
		
		System.out.println(" 연산식을 입력하시오 ");
		Scanner sc = new Scanner(System.in);
		String input= sc.nextLine();
		sc.close();
		
		String[] stringArr = input.split(" ");
		
		int result= 0;
		
		
		for (int i=0; i < stringArr.length-1; i+=2) {
			int sum =0;
			nullcheck.inspectString(stringArr[i+2]);
			
			if(stringArr[i+1].equals(Operator.ADD)) {
			sum = op.add(Integer.parseInt(stringArr[i]), Integer.parseInt(stringArr[i+2]));
			
			stringArr[i+2] = Integer.toString(sum);
			} else if (stringArr[i+1].equals(Operator.SUB)) {
			sum = op.sub(Integer.parseInt(stringArr[i]), Integer.parseInt(stringArr[i+2]));
			stringArr[i+2] = Integer.toString(sum);
			
			}	else if (stringArr[i+1].equals(Operator.MULTI)) {
				sum = op.multi(Integer.parseInt(stringArr[i]), Integer.parseInt(stringArr[i+2]));
				stringArr[i+2] = Integer.toString(sum);
				
				} else if (stringArr[i+1].equals(Operator.DIV)) {
					sum = op.divide(Integer.parseInt(stringArr[i]), Integer.parseInt(stringArr[i+2]));
					stringArr[i+2] = Integer.toString(sum);
					
					}
			
			result = Integer.parseInt(stringArr[i+2]);
		}
		System.out.println("결과는 " +result);
	}
	
	

	
}
