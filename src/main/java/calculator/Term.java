package calculator;

public class Term {
	private int value;

	private Operator operator;

	public Term(int value) {

		this(Operator.ADD, value);
	}

	public Term(Operator operator, int value) {
		this.operator = operator;
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	public Operator getOperator(){
		return operator;
	}

	public Term reduce(Term otherTerm){
		return new Term(otherTerm.getOperator().operate(this.value, otherTerm.getValue()));
	}
}
