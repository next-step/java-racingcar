package study;

public enum Operator {
    PLUS("+") { public double operate(double x, double y) { return x + y; } },
    MINUS("-") { public double operate(double x, double y) { return x - y;} },
    MULTIPLY("*") { public double operate(double x, double y) { return x * y;} },
    DIVIDE("/"){
        public double operate(double x, double y) throws Exception {
            if( x % y != 0 )
                throw new Exception("나눗셈의 경우. 결과 값이 정수로 떨어지는 경우로 한정됩니다.");
            return x / y;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    abstract double operate(double x, double y) throws Exception;
    public String getSymbol() { return symbol;}
}
