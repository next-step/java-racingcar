package racingCar.model;

import java.util.Objects;
import racingCar.util.WinnerUtils;

public final class Winner {

  private final String name;
  private final Position position;

  public Winner(String name, Position position) {
    this.name = name;
    this.position = position;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Winner winner = (Winner) o;
    return Objects.equals(name, winner.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public boolean match(Car challenger) {
    return this.position.match(WinnerUtils.getChallenger(challenger).position);
  }

  public Winner addCoWinner(Winner challenger) {
    if (!this.equals(challenger) && this.position.equals(challenger.position)) {
      return new Winner(this.name.concat(", ").concat(challenger.name), this.position);
    }
    return this;
  }


  @Override
  public String toString() {
    return name;
  }
}
