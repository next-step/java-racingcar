package racing.domain;

import java.util.Objects;
import racing.exception.RacingException;

public class CarName {
  private final String name;
  public CarName(String name){
    validate(name);
    this.name = name;
  }
  private void validate(String name){
    if(name == null || name.isEmpty()) {
      throw new RacingException(ErrorMessage.NAME_VALIDATION_EMPTY);
    }
    if(name.length() > 5) {
      throw new RacingException(ErrorMessage.NAME_VALIDATION_LENGTH);
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

  public String getName() {
    return this.name;
  }
}
