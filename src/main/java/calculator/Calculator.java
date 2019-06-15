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

		if(expression == null || expression.isEmpty()){
			throw new IllegalArgumentException("입력된 수식이 없습니다.");
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
			throw new IllegalArgumentException("수식은 연산자로 끝날 수 없습니다.");
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
