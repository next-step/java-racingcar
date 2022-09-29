package step2;

public class Positive {

  private Integer holder;

  private Positive(Integer number) {
    this.holder = number;
  }

  public static Positive of(Integer number) {
    if (number == null || number < 0) {
      throw new RuntimeException("only positive available");
    }
    return new Positive(number);
  }

  public static Positive of(String number) {
    return Positive.of(Integer.parseInt(number));
  }

  public static Positive zero() {
    return Positive.of(0);
  }

  public Positive add(Positive number) {
    if (number == null) {
      number = Positive.zero();
    }
    this.holder += number.toInteger();
    return this;
  }

  public Integer toInteger() {
    return this.holder;
  }
}
