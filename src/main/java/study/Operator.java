package study;

import study.code.ErrorCodes;
import study.exception.NotDividedByDivisorException;

public enum Operator {
    PLUS("+") { public double operate(double x, double y) { return x + y; } },
    MINUS("-") { public double operate(double x, double y) { return x - y;} },
    MULTIPLY("*") { public double operate(double x, double y) { return x * y;} },
    DIVIDE("/"){
        public double operate(double x, double y) throws Exception {
            if( x % y != 0 )
                throw new NotDividedByDivisorException();
            return x / y;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract double operate(double x, double y) throws Exception;

    public static Operator convertStringToOperator(String s) {
        switch (s) {
            case "+" : return Operator.PLUS;
            case "-" : return Operator.MINUS;
            case "*" : return Operator.MULTIPLY;
            case "/" : return Operator.DIVIDE;
        }
        throw new IllegalArgumentException();
    }

}
