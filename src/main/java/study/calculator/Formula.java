package study.calculator;

public class Formula {
	private final MyNumber first;
	private final String operator;
	private final MyNumber second;

	public Formula(MyNumber first, String operator, MyNumber second) {
		this.first = first;
		this.operator = operator;
		this.second = second;
	}

	public MyNumber calculate() {
		return Operator.of(operator)
			.operate(first, second);
	}

}
