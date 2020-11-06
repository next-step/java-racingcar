package string.calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationsDivision {

    public LinkedList<String> extractOperands(String input) {
        Stream<String> streamInput = Arrays.stream(input.split(" "));

        return streamInput
                .filter(CalculatorUitls::isNumeric)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<Operator> extractOperators(String input) {
        Stream<String> streamInput = Arrays.stream(input.split(" "));

        return streamInput
                .filter(i -> !CalculatorUitls.isNumeric(i))
                .map(Operator::getOperator)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
