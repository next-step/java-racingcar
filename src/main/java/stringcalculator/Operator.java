package stringcalculator;

public enum Operator {

    ADDITION("+"),

    SUBTRACTION("-"),

    MULTIPLICATION("*"),

    DIVISION("/") ;

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }


    public String getSymbol() {
        return symbol;
    }




}
