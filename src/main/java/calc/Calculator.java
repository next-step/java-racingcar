package calc;

import calc.operator.Divide;
import calc.operator.Minus;
import calc.operator.Multiply;
import calc.operator.Operator;
import calc.operator.Plus;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Map<String, Operator> operatorMap;

    static {
        operatorMap = new HashMap<>();
        operatorMap.put("+", new Plus());
        operatorMap.put("-", new Minus());
        operatorMap.put("*", new Multiply());
        operatorMap.put("/", new Divide());
    }

    public static MyNumber calculate(String text) {
        validText(text);

        final String[] raw = text.split(" ");

        final MyNumber left = new MyNumber(raw[0]);
        final Operator operator = operatorMap.get(raw[1]);
        final MyNumber right = new MyNumber(raw[2]);

        validOperator(operator);

        return operator.execute(left, right);
    }

    private static void validText(String text) {
        if (text == null || text.trim().equals("")) {
            throw new IllegalArgumentException("null 또는 공백 값으로 계산할 수 없습니다.");
        }
    }

    private static void validOperator(Operator operator) {
        if (operator == null) {
            throw new IllegalArgumentException("사칙연산자를 사용하세요.");
        }
    }
}
