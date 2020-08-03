package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator {

	
	/***
	 * 
	 *  사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
		입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
		나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
		문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
		예를 들어 
		2 + 3 * 4 / 2
		와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
		2+3*4/2
		
		사칙연산 기호가 아닌 경우 IllegalArgumentException throw
		사칙 연산을 모두 포함하는 기능 구현
		반복적인 패턴을 찾아 반복문으로 구현한다.
				
		
	 * 
	 */
	
	private static List<Integer> numbers;
	private static List<String> signs;
	
	public static void main(String[] args) {
		
		System.out.println("문자열을 입력해주세요 숫자와 사칙연산 사이에는 빈 공백 문자열을 넣어주세요");
		Scanner scanner = new Scanner(System.in);
		numbers = new ArrayList<>();
		signs = new ArrayList<>();
		String calculate = scanner.nextLine();
		String[] split = split(calculate);
		push(split);
		int result = calculate(numbers, signs);
		System.out.println("결과값 : " + result);
		
	}
	
	
	
	
	public static int calculate(List<Integer>numbers, List<String>signs)
	{
		int result = 0;
		for(int i = 0; i < signs.size(); i++)
		{
			switch (signs.get(i)) {
			case "+":
				result = add(numbers.get(0), numbers.get(1));
				break;
			case "-":
				result = substract(numbers.get(0), numbers.get(1));
				break;
			case "*":
				result = multiple(numbers.get(0), numbers.get(1));
				break;
			case "/":
				result = divide(numbers.get(0), numbers.get(1));
				break;
			default:
				break;
			}
			removeNumbers(numbers, result);
		}
		return result;
	}
	
	//앞의 두 수를 제거하고, 결과값을 맨 앞으로 넣음
	public static void removeNumbers(List<Integer> numbers, int result)
	{
		numbers.set(0, result);
		numbers.remove(1);
	}
	
	
	
	//연산일 경우 signs에, 아닐 경우 numbers 리스트에 넣음
	public static void push(String[] values)
	{
		for(int i = 0; i < values.length; i++)
		{
			switch (values[i]) {
			case "+":
				signs.add(values[i]);
				break;
			case "-":
				signs.add(values[i]);
				break;
			case "*":
				signs.add(values[i]);
				break;
			case "/":
				signs.add(values[i]);
				break;
			default:
				if(checkNumbers(values[i]))
				{
					numbers.add(Integer.parseInt(values[i]));
				}
				break;
			}
		}
	}
		
	public static boolean checkNumbers(String value)
	{
		if(value == null)
		{
			return false;
		}
		
		try
		{
			@SuppressWarnings("unused")
			int check = Integer.parseInt(value);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	public static int add(int a, int b)
	{
		return a+b;
	}
	public static int substract(int a, int b)
	{
		return a-b;
	}
	public static int multiple(int a, int b)
	{
		return a*b;
	}
	public static int divide(int a, int b)
	{
		return a/b;
	}
	
	
	
	//입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
	//공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
	public static String[] split(String question)
	{
		String[] values = null;
		try
		{
			values =question.split(" ");
			return values;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		return values;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
