package calculator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : byungkyu
 * @date : 2020/12/03
 * @description : 연산자
 **/
public enum Operator {
	PLUS("+"),
	MINUS("-"),
	MULTIPLY("*"),
	DIVIDE("/");

	private String operator;

	Operator(String s) {
		operator = s;
	}

	public static boolean isValid(String s) {
		return Stream.of(values())
			.collect(Collectors.toList()).contains(s);
	}

}
