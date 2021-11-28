package racingCar.domain;

import java.util.Objects;
import java.util.Random;

public class MyNumber {
  private int number;

  public MyNumber(int number) {
    this.number = number;
  }

  public static MyNumber generateRandomNumber() {
    return new MyNumber(new Random().nextInt(10));
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyNumber number1 = (MyNumber) o;
    return number == number1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
