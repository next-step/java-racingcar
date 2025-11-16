package racing.domain;

import java.util.Objects;
import racing.exception.ErrorMessage;
import racing.exception.RacingException;

public class CarName {

  private final String name;

  public CarName(String name) {
    validate(name);
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  private void validate(String name) {
    if (name == null || name.isEmpty()) {
      throw new RacingException(CarNameMessage.NAME_VALIDATION_EMPTY);
    }
    if (name.length() > 5) {
      throw new RacingException(CarNameMessage.NAME_VALIDATION_LENGTH);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarName carName = (CarName) o;
    return Objects.equals(name, carName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return this.name;
  }

  static class CarNameMessage extends ErrorMessage {

    public static final CarNameMessage NAME_VALIDATION_EMPTY =
        new CarNameMessage("이름은 비어있을 수 없습니다.");
    public static final CarNameMessage NAME_VALIDATION_LENGTH =
        new CarNameMessage("이름은 5자 이하여야 합니다.");

    private CarNameMessage(String message) {
      super(message);
    }
  }
}
