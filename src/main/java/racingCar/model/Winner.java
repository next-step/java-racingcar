package racingCar.model;

import java.util.List;
import java.util.Objects;
import racingCar.util.StringUtils;

public class Winner {

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

  public static Winner winnerCalculator(List<Car> gameParticipants) {
    Winner winner = getChallenger(gameParticipants.get(0));
    for (Car participant : gameParticipants) {
      winner = findWinner(winner, participant);
    }
    return winner;
  }

  private static Winner findWinner(Winner winner, Car challenger) {
    if (winner.match(challenger)) {
      winner = getChallenger(challenger);
    }
    return winner;
  }

  public static String coWinner(Winner winner, List<Car> otherGameParticipants) {
    String coWinner = winner.name.toString();
    for (Car otherGameParticipant : otherGameParticipants) {
      coWinner = getCoWinner(winner, coWinner, getChallenger(otherGameParticipant));
    }
    return coWinner;
  }

  private static String getCoWinner(Winner winner, String coWinner, Winner challenger) {
    if (winner.name.toString().equals(challenger.name.toString())) {
      return winner.name.toString();
    }
    if (winner.position.equals(challenger.position)) {
      coWinner = coWinner.concat(", ").concat(challenger.name.toString());
    }
    return coWinner;
  }

  private static Winner getChallenger(Car car) {
    String[] winnerSplit = StringUtils.split(car.toString(), " : ");
    return new Winner(winnerSplit[0], new Position(winnerSplit[1].length()));
  }

  private boolean match(Car challenger) {
    return this.position.match(getChallenger(challenger).position);
  }

  @Override
  public String toString() {
    return name.toString();
  }
}
