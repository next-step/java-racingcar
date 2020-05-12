package Calculator;

import java.util.Arrays;
import java.util.function.Function;

public enum OperatorEnum {
	PLUS("+",value -> new AddCalculator()),
	MINUS("-",value ->  new SubCalculator()),
	MULTIPLE("*",value ->  new MultipleCalculator()),
	DIVIDE("/",value ->  new DivisionCalculator());
	
	String oper;
	Function<OperatorEnum, Calculator> expression;
	
	OperatorEnum(String str,Function<OperatorEnum,Calculator> aa) {
		// TODO Auto-generated constructor stub
		this.oper = str;
		this.expression = aa;
	}
	
	public Calculator calculate(OperatorEnum value) {
		return expression.apply(value);
	}
	
	public static OperatorEnum find(String oper) {
		return Arrays.stream(OperatorEnum.values()).filter(enums -> enums.oper.equals(oper)).findAny().orElseThrow(() ->new IllegalArgumentException());
	}

}
