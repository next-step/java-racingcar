public enum Operator {
  PLUS("+") {
    public int apply(int prev, int next) { return prev + next; }
  },
  MINUS("-") {
    public int apply(int prev, int next) { return prev - next; }
  },
  MULTIPLE("*") {
    public int apply(int prev, int next) { return prev * next; }
  },
  DIVIDE("/") {
    public int apply(int prev, int next) { return Math.floorDiv(prev, next); }
  };

  public final String symbol;
  public abstract int apply(int prev, int next);

  Operator(String symbol) {
    this.symbol = symbol;
  }
}