package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCaculator {

	Scanner sc = new Scanner(System.in);

	public void caculate() {
		System.out.println("계산할 문자열을 입력해주세요");
		String inputString = sc.nextLine();
		System.out.println(inputString);

		// 1. 숫자, 사칙연산만올 것
		validate(inputString);
		// 2. 빈 공백으로 숫자, 사칙연산 분리
		List<String> operatorList = new ArrayList<>();
		List<Integer> inputNumberList = new ArrayList<>();
		analyzeInputString(inputString, operatorList, inputNumberList);

		// 2. 앞에서 부터 차례대로 연산한다. + - * /
		Integer frontNumber = null;
		for (int i = 0; i < operatorList.size(); i++) {
			String operator = operatorList.get(i);
			if (i == 0) {
				frontNumber = inputNumberList.get(i);
			}
			Integer rearNumber = inputNumberList.get(i + 1);
			switch (operator) {
				case "+":
					frontNumber = plus(frontNumber, rearNumber);
					break;
				case "-":
					frontNumber = minus(frontNumber, rearNumber);
					break;
				case "*":
					frontNumber = multiply(frontNumber, rearNumber);
					break;
				case "/":
					frontNumber = divide(frontNumber, rearNumber);
					break;
				default:
					throw new IllegalArgumentException();
			}

		}
		//todo 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정 ?
		System.out.println("##########");
		System.out.println(frontNumber);

	}

	private void validate(String inputString) {
		List<String> inputList = Arrays.asList(inputString.split(" "));
		if (inputList.size() == 0) { //공백 입력 시
			throw new IllegalArgumentException();
		}
		for (String number : inputList) {
			if (!isValid(number)) {
				throw new IllegalArgumentException();
			}
		}
	}

	private boolean isValid(String number) {
		if (!(number.matches("\\d+") || number.matches("[\\+*\\/-]"))) {
			//숫자도 아니고 사칙연산에도 해당되지 않은 경우
			return false;
		}
		return true;
	}

	private Integer divide(Integer frontNumber, Integer rearNumber) {
		Integer result = frontNumber / rearNumber;
		System.out.println(result);
		return result;
	}

	private Integer multiply(Integer frontNumber, Integer rearNumber) {
		Integer result = frontNumber * rearNumber;
		System.out.println(result);
		return result;
	}

	private Integer minus(Integer frontNumber, Integer rearNumber) {
		Integer result = frontNumber - rearNumber;
		System.out.println(result);
		return result;
	}

	private Integer plus(Integer frontNumber, Integer rearNumber) {
		Integer result = frontNumber + rearNumber;
		System.out.println(result);
		return result;
	}

	private void analyzeInputString(String inputString, List<String> operatorList, List<Integer> inputNumberList) {
		String[] inputArr = inputString.split(" ");
		for (int i = 0; i < inputArr.length; i++) {
			if (i % 2 == 1) {
				operatorList.add(inputArr[i]);
			} else {
				inputNumberList.add(Integer.parseInt(inputArr[i]));
			}
		}
	}
}
