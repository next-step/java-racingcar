package step1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Parser {

	private final List<BigDecimal> numbers = new ArrayList<>();
	private final List<Operator> operators = new ArrayList<>();

	/**
	 * 생성자로 주어진 문자열을 받아, 숫자와 연산자로 파싱한다
	 * 파싱된 숫자와 연산자는 파서가 가지고 있다.
	 * 파싱에 실패하면 IllegalArgumentException을 반환한다
	 */
	public Parser(String str) {
		String[] separatedString = parseString(str);
		validateLength(separatedString.length);
		insertAllStringIntoList(separatedString);
	}

	private String[] parseString(String str) {
		return str.split(" +");
	}

	private void validateLength(int length) {
		if (length % 2 == 0) {
			throw new IllegalArgumentException(String.format("문자열에 들어 있는 원소 개수를 확인해주세요! %d개가 들어왔습니다", length));
		}
	}

	private void insertAllStringIntoList(String[] separatedString) {
		for (int i = 0, end = separatedString.length; i < end; i++) {
			addNumberIfOrderIsEven(separatedString[i], i);
			addOperatorIfOrderIsOdd(separatedString[i], i);
		}
	}

	private void addNumberIfOrderIsEven(String str, int order) {
		if (order % 2 == 0) {
			numbers.add(createBigDecimal(str));
		}
	}

	private BigDecimal createBigDecimal(String str) {
		try {
			return new BigDecimal(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

	private void addOperatorIfOrderIsOdd(String str, int order) {
		if (order % 2 == 1) {
			operators.add(Operator.of(str));
		}
	}

	public List<BigDecimal> getNumbers() {
		return numbers;
	}

	public List<Operator> getOperators() {
		return operators;
	}

}
