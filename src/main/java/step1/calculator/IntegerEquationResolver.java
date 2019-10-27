package step1.calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IntegerEquationResolver implements EquationResolver<Integer> {
    private static final Map<String, IntegerOperators> OPERATORS_MAP = Arrays.stream(IntegerOperators.values())
                                                                             .collect(Collectors.toMap(IntegerOperators::getOperator, integerOperators -> integerOperators));
    private static final Pattern ONLY_INTEGER = Pattern.compile("^-?\\d+");

    private IntegerEquationResolver() {}

    public static EquationResolver<Integer> getInstance() {
        return Holder.instance;
    }

    @Override
    public ProcessUnit<Integer> resolveEquation(String equation) {
        Queue<Integer> operandQueue = new LinkedList<>();
        Queue<Operators<Integer>> integerOperatorsQueue = new LinkedList<>();
        parseEquation(equation, operandQueue, integerOperatorsQueue);

        return new ProcessUnit<>(operandQueue, integerOperatorsQueue);
    }

    private void parseEquation(String equation, Queue<Integer> operandQueue, Queue<Operators<Integer>> integerOperatorsQueue) {
        for (String unit : getSplitUnits(equation)) {
            if (isOperand(unit)) {
                operandQueue.add(Integer.parseInt(unit));
            } else {
                integerOperatorsQueue.add(getMatchOperator(unit));
            }
        }
    }

    private IntegerOperators getMatchOperator(String operator) {
        return Optional.ofNullable(OPERATORS_MAP.get(operator))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported Operator, operator= "+ operator));
    }

    private List<String> getSplitUnits(String equation) {
        return Arrays.asList(splitByWhitespace(equation));
    }

    private boolean isOperand(String s) {
        return ONLY_INTEGER.matcher(s).find();
    }

    private static class Holder {
        private static final IntegerEquationResolver instance = new IntegerEquationResolver();
    }
}
