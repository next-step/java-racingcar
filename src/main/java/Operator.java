public enum Operator {
  PLUS("+"),
  MINUS("-"),
  MULTIPLE("*"),
  DIVIDE("/");

  public final String symbol;

  Operator(String symbol) {
    this.symbol = symbol;
  }
}