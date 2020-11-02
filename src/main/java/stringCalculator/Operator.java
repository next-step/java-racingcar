package stringCalculator;

public class Operator {

    Symbol symbol;

    public Operator(String state){
        symbol = new Symbol(state);
    }

    public int operate(int a, int b){

        if (symbol.isSameSymbol("+")) return a + b;
        if (symbol.isSameSymbol("-")) return a - b;
        if (symbol.isSameSymbol("*")) return a * b;
        if (b == 0) throw new DivideByZeroException();
        if (symbol.isSameSymbol("/")) return a / b;

        return 0;

    }
}
