package calculator;

public class MyNumber {

  private final int number;

  public MyNumber(String number) {
    this(Integer.parseInt(number));
  }

  public MyNumber(int number) {
    this.number = number;
  }

  public MyNumber add(MyNumber target) {
    return new MyNumber(number + target.number);
  }

  public MyNumber subtract(MyNumber target) {
    return new MyNumber(number - target.number);
  }

  public MyNumber multiply(MyNumber target) {
    return new MyNumber(number * target.number);
  }

  public MyNumber divideBy(MyNumber target) {
    if (target.number == 0) {
      throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
    }
    return new MyNumber(number / target.number);
  }

  public int getNumber() {
    return number;
  }
}
