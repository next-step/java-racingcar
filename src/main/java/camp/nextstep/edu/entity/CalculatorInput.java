package camp.nextstep.edu.entity;

import static camp.nextstep.edu.util.StringUtil.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.exception.UserException;

public class CalculatorInput {

	private List<String> inputs;
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
		List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
		this.inputs = inputSplitedByBlank.subList(1, inputSplitedByBlank.size());

		if (!isNumeric(inputSplitedByBlank.get(0))) {
			throw new UserException();
		}

		this.initialNumber = Integer.parseInt(inputSplitedByBlank.get(0));
	}

	public List<String> getInputs() {
		return inputs;
	}

	public int getInitialNumber() {
		return initialNumber;
	}

	public void setInitialNumber(int initialNumber) {
		this.initialNumber = initialNumber;
	}
}
