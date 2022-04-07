package step2;

public class PositiveInteger {

  private int number;

  private PositiveInteger() {}

  public static PositiveInteger createPositiveIntegerByParsingString(String strNumber) {
    int number = Integer.parseInt(strNumber);;
    if (number < 0) {
      throw new RuntimeException("음수는 변환할 수 없습니다.");
    }
    return createPositiveInteger(number);
  }

  public static PositiveInteger createPositiveInteger(int number) {
    PositiveInteger positiveInteger = new PositiveInteger();
    positiveInteger.number = number;
    return positiveInteger;
  }

  public int sum(int otherNumber) {
    return otherNumber + this.number;
  }


}
