package calculator;

import resource.StringResources;

import java.util.HashMap;
import java.util.Map;

public class OperatorMapper {

    private final static Map<Character, Operator> mapper = new HashMap<>();

    static {
        mapper.put('+', Operator.PLUS);
        mapper.put('-', Operator.SUBTRACT);
        mapper.put('*', Operator.MULTIPLY);
        mapper.put('/', Operator.DIVISION);
    }

    public static Operator getOperator(char op) throws IllegalArgumentException {

        if (mapper.containsKey(op)) {
            return mapper.get(op);
        }

        throw new IllegalArgumentException(StringResources.ERR_INCORRECT_OPERATOR);
    }
}