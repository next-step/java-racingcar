package racing_game.core;

public class Positive {
  private Integer holder;

  private Positive(Integer number) {
    this.holder = number;
  }

  public static Positive of(Integer number) {
    if (number == null || number < 0) {
      throw new NumberFormatException("only positive available");
    }
    return new Positive(number);
  }

  public static Positive of(String number) {
    return Positive.of(Integer.parseInt(number));
  }

  public static Positive zero() {
    return Positive.of(0);
  }

  public static Positive copy(Positive number) {
    if (number == null) {
      number = Positive.zero();
    }
    return Positive.of(number.toInt());
  }

  public Positive add(Positive number) {
    if (number == null) {
      number = Positive.zero();
    }
    this.holder += number.toInt();
    return this;
  }

  public Positive add(Integer number) {
    return add(Positive.of(number));
  }

  public Positive addOne() {
    return add(1);
  }

  public Integer toInt() {
    return this.holder;
  }
}
