package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operator {

    private final static List<String> SYMBOLS = new ArrayList<>(
        Arrays.asList(Calculator.ADD, Calculator.SUB, Calculator.MUL, Calculator.DIV));
    private final List<String> operators;

    public Operator() {
        operators = new ArrayList<>();
    }

    public void add(String ope) {
        if (!SYMBOLS.contains(ope)) {
            throw new IllegalArgumentException(ope + " 는 연산기호가 아닙니다.");
        }
        operators.add(ope);
    }

    public List<String> getOperators() {
        return operators;
    }
}
