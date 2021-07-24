package stringCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public interface Operation {
    String apply(String a, String b);
}

enum FourOperation implements Operation {
    PLUS("+", (a,b) -> (Integer.parseInt(a)+Integer.parseInt(b))+""),
    MINUS("-", (a,b) -> (Integer.parseInt(a)-Integer.parseInt(b))+""),
    MULT("*", (a,b) -> (Integer.parseInt(a)*Integer.parseInt(b))+""),
    DIVIDE("/",(a,b) -> (Integer.parseInt(a)/Integer.parseInt(b))+"");

    private final String symbol;
    private final BinaryOperator<String> operator;

    FourOperation(String symbol,BinaryOperator<String> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    private static final Map<String,FourOperation> OP_MAP = new HashMap<>();
    static {
        for (FourOperation f : FourOperation.values()) {
            OP_MAP.put(f.symbol,f);
        }
    }

    public static FourOperation of(String operator) throws IllegalArgumentException{
        if(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")){
            throw new IllegalArgumentException("사칙연산 기호가 아닌 문자를 입력하였습니다.");
        }
        return OP_MAP.get(operator);
    }

    @Override
    public String apply(String a, String b) {
        return operator.apply(a, b);
    }
}
