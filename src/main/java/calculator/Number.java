package calculator;

public class Number {

  private int first;
  private int second;

  public Number(int first, int second) {
    this.first = first;
    this.second = second;
  }

  public int plus() {
    return this.first + this.second;
  }

  public int minus() {
    return this.first - this.second;
  }

  public int multiply() {
    return this.first * this.second;
  }

  public int divide() {
    if (this.second == 0) {
      throw new IllegalArgumentException("cannot divided by zero");
    }
    return this.first / this.second;
  }
}
