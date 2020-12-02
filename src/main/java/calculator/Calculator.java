package calculator;

import java.util.stream.Stream;

class Calculator {

	Long calculate(Long firstOperand, OperatingEntry... operatingEntries) {
		Accumulator accumulator = Accumulator.of(firstOperand);
		Stream.of(operatingEntries).forEach(accumulator::applyOperatingEntry);
		return accumulator.getResult();
	}
}
