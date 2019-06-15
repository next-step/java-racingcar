package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {



	List<Term> terms;

	public Calculator(String input) {
		terms = parseInput(input);
	}

	private List<Term> parseInput(String expression){
		List<Term> terms = new ArrayList<>();
		String[] tokens = expression.split(" ");
		Operator operator = Operator.ADD;
		for(String token : tokens){
			try {
				int value = Integer.parseInt(token);
				terms.add(new Term(operator, value));
				operator = null;
			}catch (NumberFormatException e){
				operator = Operator.valueOfSign(token);
			}
		}

		return terms;
	}

	public int execute() {
		return terms.stream()
				.reduce((subtotal, element) -> subtotal.reduce(element))
				.orElse(new Term(0))
				.getValue();
	}


	private class Term {
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
			int initial = this.value;
			switch(otherTerm.getOperator()){
				case ADD:
					initial += otherTerm.getValue();
					break;
				case DIFFERENCE:
					initial -= otherTerm.getValue();
					break;
				case MULTIPLY:
					initial *= otherTerm.getValue();
					break;
				default:
					throw new IllegalStateException("방법을 알 수 없는 연산자");
			}

			return new Term(initial);
		}
	}
}
