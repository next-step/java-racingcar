package camp.nextstep.edu.entity;

import static camp.nextstep.edu.util.StringUtil.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import camp.nextstep.edu.exception.UserException;

public class CalculatorInput {

	private Queue<String> inputs;
	private int initialNumber;

	public CalculatorInput(String input) {
		this.checkParam(input);
		this.init(input);
	}

	private void checkParam(String input) {
		if (input == null || input.equals("")) {
			throw new UserException();
		}
	}

	private void init(String input) {
		this.inputs = new LinkedList<>(Arrays.asList(input.split(" ")));
		String initialNumberInputString = Optional.ofNullable(this.inputs.poll()).orElse("");
		if (!isNumeric(initialNumberInputString)) {
			throw new UserException();
		}

		this.initialNumber = Integer.parseInt(initialNumberInputString);
	}

	public Queue<String> getInputs() {
		return inputs;
	}

	public int getInitialNumber() {
		return initialNumber;
	}
}
