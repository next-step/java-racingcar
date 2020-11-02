package stringCalculator;

import java.util.ArrayList;

public class Operator {
    String symbol;

    public Operator(String symbol){
        this.symbol = symbol;
    }

    public boolean isSameSymbol(String symbol){
        return this.symbol.equals(symbol);
    }

public int operate(int a, int b){

    if (symbol.equals("+")) return a + b;
    if (symbol.equals("-")) return a - b;
    if (symbol.equals("*")) return a * b;
    if (b == 0) throw new DivideByZeroException();
    if (symbol.equals("/")) return a / b;

    return 0;

}
}
