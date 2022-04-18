package racingCar.model;

import java.util.List;
import java.util.Objects;
import racingCar.util.WinnerUtils;

public final class Winner {

  private final CarName name;
  private final Position position;

  public Winner(String name, Position position) {
    this.name = new CarName(name);
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
    return Objects.equals(name.toString(), winner.name.toString());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name.toString());
  }


  public String coWinner(Winner winner, List<Car> otherGameParticipants) {
    String coWinner = winner.name.toString();
    for (Car otherGameParticipant : otherGameParticipants) {
      coWinner = getCoWinner(winner, coWinner, WinnerUtils.getChallenger(otherGameParticipant));
    }
    return coWinner;
  }

  public Winner findWinner(Winner winner, Car challenger) {
    if (winner.match(challenger)) {
      winner = WinnerUtils.getChallenger(challenger);
    }
    return winner;
  }

  private String getCoWinner(Winner winner, String coWinner, Winner challenger) {
    if (winner.name.toString().equals(challenger.name.toString())) {
      return winner.name.toString();
    }
    if (winner.position.equals(challenger.position)) {
      coWinner = coWinner.concat(", ").concat(challenger.name.toString());
    }
    return coWinner;
  }


  private boolean match(Car challenger) {
    return this.position.match(WinnerUtils.getChallenger(challenger).position);
  }

  @Override
  public String toString() {
    return name.toString();
  }
}
