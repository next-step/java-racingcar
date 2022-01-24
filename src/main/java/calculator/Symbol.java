package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Symbol {

    private final static List<String> SYMBOLS = new ArrayList<>(
        Arrays.asList(Calculator.ADD, Calculator.SUB, Calculator.MUL, Calculator.DIV));
    private final List<String> symbols;

    public Symbol() {
        symbols = new ArrayList<>();
    }

    public void add(String ope) {
        if (!SYMBOLS.contains(ope)) {
            throw new IllegalArgumentException(ope + " 는 연산기호가 아닙니다.");
        }
        symbols.add(ope);
    }

    public String get(int index) {
        return symbols.get(index);
    }
}
