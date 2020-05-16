package stringCalculator.domain;

import java.util.HashMap;
import java.util.Map;

public class CalculateInfo {
	private int number;
	private String operator;
	private int result;
	
	private static Map<String, Operator> operatorMap = new HashMap<>();
	
	static {
		operatorMap.put("+", Operator.ADD);
		operatorMap.put("-", Operator.SUBTRACT);
		operatorMap.put("*", Operator.MULTIPLY);
		operatorMap.put("/", Operator.DIVIDE);
	}
	
	public CalculateInfo(int result, int number, String operator) {
		this.result = result;
		this.number = number;
		this.operator = operator;
	}

	public Operator findOperator(String operator) {
		return operatorMap.get(operator);
	}
	
	public int calculate() {
		return findOperator(operator).calculate(result, number);
	}
}
