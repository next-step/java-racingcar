package stringcalculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Operator {

    ADDITION("+"),

    SUBTRACTION("-"),

    MULTIPLICATION("*"),

    DIVISION("/") ;

    private final String symbol;

    private static final Map<String, Operator> lookup = new HashMap<String, Operator>();

    static {
        Arrays.stream(Operator.values())
                .forEach(operator -> lookup.put(operator.getSymbol(),operator));
    }

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator getBySymbol(String symbol) {

       if(!lookup.containsKey(symbol)) throw new IllegalArgumentException(symbol+" is not valid symbol");

       return lookup.get(symbol);
    }
}
