package stringCalculator;

import java.util.HashMap;
import java.util.Map;

public interface Operation {
    String apply(String a, String b);
}

enum FourOperation implements Operation {
    PLUS("+"){
        public String apply(String a, String b) {
            return (Integer.parseInt(a) + Integer.parseInt(b))+"";
        }
    },
    MINUS("-"){
        public String apply(String a, String b) {
            return (Integer.parseInt(a) - Integer.parseInt(b))+"";
        }
    },
    MULT("*"){
        public String apply(String a, String b) {
            return (Integer.parseInt(a) * Integer.parseInt(b))+"";
        }
    },
    DIVIDE("/"){
        public String apply(String a, String b) {
            return (Integer.parseInt(a) / Integer.parseInt(b))+"";
        }
    };

    private final String operator;

    FourOperation(String operator) {
        this.operator = operator;
    }

    private static final Map<String,FourOperation> OP_MAP = new HashMap<>();
    static {
        for (FourOperation f : FourOperation.values()) {
            OP_MAP.put(f.operator,f);
        }
    }

    public static FourOperation of(String operator) throws IllegalArgumentException{
        if(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")){
            throw new IllegalArgumentException("사칙연산 기호가 아닌 문자를 입력하였습니다.");
        }
        return OP_MAP.get(operator);
    }

}
