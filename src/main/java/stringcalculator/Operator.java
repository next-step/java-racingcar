package stringcalculator;

public interface Operator {
    int calculate(int x, int y);

    boolean match(String symbol);
}
