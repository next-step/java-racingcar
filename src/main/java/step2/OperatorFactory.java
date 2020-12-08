package step2;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
	static Map<String, Operator> operatorMap = new HashMap<>();
	public static void init() {
		operatorMap.put("+", new PlusOperator());
	}
	public static Operator getOperator(String symbol) {
		return operatorMap.get(symbol);
	}
}
