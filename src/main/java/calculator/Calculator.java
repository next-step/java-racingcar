package calculator;

import java.util.List;

class Calculator {

	Long calculate(Long firstOperand, List<OperatingEntry> operatingEntryList) {
		Accumulator accumulator = Accumulator.of(firstOperand);
		operatingEntryList.forEach(accumulator::applyOperatingEntry);
		return accumulator.getResult();
	}
}
