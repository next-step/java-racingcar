package study.step2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static study.step2.Exception.*;

public class SimpleInterpreter implements Interpreter {

    private static final String DELIMITER = " ";
    private static final boolean IS_NUMERIC = true;
    private final Map<String, Operator> operatorMap;

    public SimpleInterpreter() {
        this.operatorMap = Operator.getOperatorMap();
    }

    @Override
    public Expression read(String input) {
        validation(input);
        return toExpression(partitionIntoNumberAndOperator(input));
    }

    private void validation(String input) {
        NULL_INPUT.validation(input, NULL_INPUT.getMessage());
        BLANK_INPUT.validation(input, BLANK_INPUT.getMessage());
    }

    private Expression toExpression(Map<Boolean, List<String>> partition) {
        return new Expression(getNumbers(partition), getOperators(partition));
    }

    private Map<Boolean, List<String>> partitionIntoNumberAndOperator(String input) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.partitioningBy(text -> isNumberTurn(index)));
    }

    private boolean isNumberTurn(AtomicInteger index) {
        return index.getAndIncrement() % 2 == 0;
    }

    private List<Integer> getNumbers(Map<Boolean, List<String>> partition) throws NumberFormatException {
        return partition.get(IS_NUMERIC).stream()
                .map(this::getNumberOrThrow)
                .collect(Collectors.toList());
    }

    private List<Operator> getOperators(Map<Boolean, List<String>> partition) throws IllegalArgumentException {
        return partition.get(!IS_NUMERIC).stream()
                .map(this::getOperatorOrThrow)
                .collect(Collectors.toList());
    }

    private Integer getNumberOrThrow(String text) {
        return Optional.of(Integer.parseInt(text))
                .orElseThrow(() -> new NumberFormatException(text));
    }

    private Operator getOperatorOrThrow(String text) {
        Operator operator = operatorMap.get(text);
        NOT_OPERATOR.validation(operator, NOT_OPERATOR.getMessage(text));
        return operator;
    }

}
