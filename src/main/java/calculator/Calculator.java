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

		if(expression == null){
			throw new IllegalArgumentException();
		}

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

		if(operator != null){
			throw new IllegalArgumentException();
		}

		return terms;
	}

	public int execute() {
		return terms.stream()
				.reduce((subtotal, element) -> subtotal.reduce(element))
				.orElse(new Term(0))
				.getValue();
	}
}
