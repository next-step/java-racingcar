package calculator;

import java.util.HashMap;

public enum SymbolType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String symbol;
    private static HashMap<String, SymbolType> symbolStringHashMap = new HashMap<>();

    static {
        for (SymbolType symbolType : SymbolType.values()) {
            symbolStringHashMap.put(symbolType.symbol, symbolType);
        }
    }

    SymbolType(String symbol) {
        this.symbol = symbol;
    }

    public static SymbolType getOperator(String symbol) {
        if (!symbolStringHashMap.containsKey(symbol)) {
            throw new IllegalArgumentException("Given symbol is not valid. Symbol: " + symbol);
        }
        return symbolStringHashMap.get(symbol);
    }
}
