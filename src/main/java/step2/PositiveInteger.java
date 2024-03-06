package step2;

public class PositiveInteger {
  private int value;

  public PositiveInteger(String stringValue) {
    this.value = Integer.parseUnsignedInt(stringValue);
  }

  public PositiveInteger(Integer intValue) {
    if (intValue < 0) {
      throw new IllegalArgumentException("negative value not allowed");
    }
    this.value = intValue;
  }

  public Integer sumInt(Integer value) {
    return this.value + value;
  }

  public static PositiveInteger sum(PositiveInteger p1, PositiveInteger p2) {
    return new PositiveInteger(p1.value + p2.value);
  }

  public PositiveInteger add(PositiveInteger pInt) {
    this.value += pInt.value;
    return this;
  }

  public Integer getValue() {
    return this.value;
  }
}
