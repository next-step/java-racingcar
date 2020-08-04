package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		List<String> signs = new ArrayList<>();

		System.out.println("문자열을 입력해주세요 숫자와 사칙연산 사이에는 빈 공백 문자열을 넣어주세요");
		Scanner scanner = new Scanner(System.in);

		String calculate = scanner.nextLine();
		String[] split = split(calculate);
		
		seperatePush(split, numbers, signs);
		int result = calculateWithList(numbers, signs);
		System.out.println("결과값 : " + result);
		
	}
	
	//사칙연산 나누기
	public static int calculateWithSign(int num1, int num2, String sign) {
		if("+".equals(sign))
			return num1 + num2;
		else if("-".equals(sign))
			return num1 - num2;
		else if("*".equals(sign))
			return num1 * num2;
		else 
			return num1 / num2;
	}
	
	public static int calculateWithList(List<Integer>numbers, List<String>signs) {
		int result = 0;
		for(int i =0; i < signs.size(); i++)
		{
			result = calculateWithSign(numbers.get(0), numbers.get(1), signs.get(i));
			removeNumbers(numbers, result);
		}
		return result;
	}
	
	//앞의 두 수를 제거하고, 결과값을 맨 앞으로 넣음
	public static void removeNumbers(List<Integer> numbers, int result) {
		numbers.set(0, result);
		numbers.remove(1);
	}
		
	//숫자와 연산으로 분리해서 넣음
	public static void seperatePush(String[] values, List<Integer>numbers, List<String>signs) {
		for(int i = 0; i < values.length; i++) {
			pushSign(values[i], signs);
			pushNumber(values[i], numbers);
		}
	}
	
	//사직연산일 경우 signs 리스트에 넣어줌
	public static void pushSign(String values, List<String>signs){
		if("+".equals(values) || "-".equals(values) || "*".equals(values) || "/".equals(values))
			signs.add(values);
	}
	
	//사칙연산이 아닐경우 numbers 리스트에 넣어줌
	public static void pushNumber(String values, List<Integer>numbers)
	{
		if(!("+".equals(values) || "-".equals(values) || "*".equals(values) || "/".equals(values)))
			numbers.add(Integer.parseInt(values));
	}
	
	
	
	//공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
	public static String[] split(String question) {
		return question.split(" ");
	}	
}
