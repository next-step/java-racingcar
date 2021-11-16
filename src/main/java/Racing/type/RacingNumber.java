package Racing.type;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RacingNumber {

  private final static double RANDOM_BOUND = 5.0;
  private final double value;

  public RacingNumber(int number) {
    value = number;
  }

  public RacingNumber(double number) {
    value = number;
  }

  public static RacingNumber getRandomNumber() {
    int number = new Random().nextInt((int) RacingNumber.RANDOM_BOUND) + 4;
    return new RacingNumber(number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RacingNumber that = (RacingNumber) o;
    return Double.compare(that.value, value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  public int parseInt() {
    return (int) value;
  }

  public <T> List<T> generateInstanceList(Class<T> targetClass) {
    List<T> result = new ArrayList<>();
    for (int counter = 0; counter < this.value; counter++) {
      result.add(generateInstance(targetClass));
    }
    return result;
  }

  private <T> T generateInstance(Class<T> targetClass) {
    Constructor<T>[] declaredConstructors = (Constructor<T>[]) targetClass
        .getDeclaredConstructors();
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
        "해당 클래스는 Arguments 가 없는 생성자가 없습니다.");
    try {
      return Arrays.stream(declaredConstructors)
          .filter((constructor) -> constructor.getParameterCount() == 0)
          .findAny()
          .orElseThrow(() -> illegalArgumentException)
          .newInstance();
    } catch (Exception e) {
      throw illegalArgumentException;
    }
  }
}
