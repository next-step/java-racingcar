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
		for(String token : tokens){
			try {
				int value = Integer.parseInt(token);
				terms.add(new Term(value));
			}catch (NumberFormatException e){
				continue;
			}
		}

		return terms;
	}

	public int execute() {
		return terms.stream()
				.reduce((subtotal, element) -> new Term(subtotal.getValue() + element.getValue()))
				.orElse(new Term(0))
				.getValue();
	}

	private class Term {
		int value;

		public Term(int value) {

			this.value = value;
		}

		public int getValue(){
			return value;
		}
	}
}
