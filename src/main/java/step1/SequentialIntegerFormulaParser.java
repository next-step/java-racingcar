package step1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static step1.IntegerFormulaNodeOperatorFactory.divide;
import static step1.IntegerFormulaNodeOperatorFactory.minus;
import static step1.IntegerFormulaNodeOperatorFactory.multiply;
import static step1.IntegerFormulaNodeOperatorFactory.plus;

public class SequentialIntegerFormulaParser implements FormulaParser {
    // TODO: 외부에서 주입
    private static final String FORMULA_DELIMITER = " ";
    private static final Map<String, FormulaNodeOperator<Integer>> operatorMap = new HashMap<>();

    static {
        operatorMap.put(OperationType.PLUS.text(), plus());
        operatorMap.put(OperationType.MINUS.text(), minus());
        operatorMap.put(OperationType.DIVIDE.text(), divide());
        operatorMap.put(OperationType.MULTIPLY.text(), multiply());
    }

    @Override
    public Formula<Integer> parse(final String formula) {
        final String[] split = formula.split(FORMULA_DELIMITER);

        final List<FormulaNodeValue<Integer>> values = Arrays.stream(split)
                                                             .filter(SequentialIntegerFormulaParser::isNumeric)
                                                             .map(Integer::parseInt)
                                                             .map(IntegerFormulaNodeValue::new)
                                                             .collect(Collectors.toList());
        final List<FormulaNodeOperator<Integer>> operators = Arrays.stream(split)
                                                                   .filter(s -> !isNumeric(s))
                                                                   .map(operatorMap::get)
                                                                   .collect(Collectors.toList());

        return new Formula<>(values, operators);
    }

    private static boolean isNumeric(final String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
