package step2;

public class PositiveInteger {

  private int number;

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

  @Deprecated
  public static PositiveInteger[] from(String[] values) {
    final int length = values.length;
    PositiveInteger[] positiveIntegers = new PositiveInteger[length];
    for (int i=0; i<length; i++) {
      positiveIntegers[i] = createPositiveIntegerByParsingString(values[i]);
    }
    return positiveIntegers;
  }

  public int sum(int otherNumber) {
    return otherNumber + this.number;
  }


}
