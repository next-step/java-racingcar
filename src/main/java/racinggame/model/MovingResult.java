package racinggame.model;

import static racinggame.message.MessageConstant.NO_FOUND_WINNER;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racinggame.vo.CarSateInRace;

/*
우승자 결정로직을 위한 클래스
 */
public class MovingResult {

  private static final int FIRST_INDEX = 0;

  private List<CarSateInRace> carSateInRaces;

  public MovingResult(List<CarSateInRace> carSateInRaces) {
    this.carSateInRaces = carSateInRaces;
  }

  public List<CarSateInRace> getCarSateInRaces() {
    return carSateInRaces;
  }

  public String getWinnerCarNames() {
    List<CarSateInRace> origin = this.carSateInRaces;
    if (origin.size() == 0) {
      throw new IllegalStateException(NO_FOUND_WINNER);
    }
    return collectWinnerCarName(sortByPosition(origin));
  }

  private List<CarSateInRace> sortByPosition(List<CarSateInRace> carSateInRaces) {
    return carSateInRaces.stream()
        .sorted(Comparator.comparingInt(CarSateInRace::getRacingPosition).reversed())
        .collect(Collectors.toList());
  }

  private String collectWinnerCarName(List<CarSateInRace> sortedCarSateInRaces) {
    int winnerPosition = sortedCarSateInRaces.get(FIRST_INDEX).getRacingPosition();
    return sortedCarSateInRaces.stream()
        .filter(carSateInRace -> carSateInRace.getRacingPosition() == winnerPosition)
        .map(carSateInRace -> carSateInRace.getCarName())
        .collect(Collectors.joining(","));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MovingResult that = (MovingResult) o;
    return Objects.equals(carSateInRaces, that.carSateInRaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carSateInRaces);
  }
}
