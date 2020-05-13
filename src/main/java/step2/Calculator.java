package step2;

public enum Calculator {
  PLUS("+") {
    public int calculate(int x, int y) {
      return x + y;
    }
  },
  MINUS("-") {
    public int calculate(int x, int y) {
      return x - y;
    }
  },
  MULTIPLY("*") {
    public int calculate(int x, int y) {
      return x * y;
    }
  },
  DIVIDE("/") {
    public int calculate(int x, int y) {
      return x / y;
    }
  };

  private final String symbol;

  Calculator(String symbol) {
    this.symbol = symbol;
  }

  String getSymbol() {
    return symbol;
  }

  public abstract int calculate(int a, int b);
}
