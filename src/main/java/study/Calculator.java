package study;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

	private int result;

	private Queue<Integer> operands = new LinkedList<Integer>();

	private Queue<String> operators = new LinkedList<String>();

	public Integer calc(String input) {
		// 입력값이 null or 빈 공백 문자일 경우 Exception 발생
		if (input.equals("") ||	input == null) {
			throw new IllegalArgumentException("빈 공백이 들어왔습니다.");
		}

		// 초기화 작업
		init(input);

		// 초기화 이후에도 Queue가 비어있으면 Exception 발생
		if (operands.isEmpty()) {
			throw new IllegalArgumentException("수식이 잘못되었습니다.");
		}

		if (operators.isEmpty()) {
			throw new IllegalArgumentException("수식이 잘못되었습니다.");
		}

		result = operands.poll();

		// 연산
		while (!operators.isEmpty()) {
			Operator operator = Operator.of(operators.poll());

			// 연산자가 존재하는데 피연산자가 있어야함
			if (operands.isEmpty()) {
				throw new IllegalArgumentException("수식이 잘못되었습니다.");
			}

			result = operator.calc(result, operands.poll());
		}
		return result;
	}

	private void init(String input) {
		String[] str = input.split(" ");

		for (String s : str) {
			add(s);
		}
	}

	private void add(String str) {
		if (isNum(str)) {
			operands.add(Integer.valueOf(str));
		} else {
			// 피연산자가 없이 연산자가 먼저 들어오면 예외 발생
			if (operands.isEmpty()) {
				throw new IllegalArgumentException("수식이 잘못되었습니다.");
			}
			
			operators.add(str);
		}
	}

	private boolean isNum(String str) {
		if (str.equals(""))	return false;

		return str.matches("-?\\d+");
	}
}
