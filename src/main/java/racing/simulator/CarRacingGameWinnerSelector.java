package racing.simulator;

import racing.types.RacingCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGameWinnerSelector {

  public List<RacingCar> select(List<RacingCar> racingCars) {
    if (racingCars.isEmpty()) {
      return new ArrayList<>(); // 빈 리스트 처리
    }

    int maxLocation = racingCars.stream()
        .max(Comparator.comparingInt(RacingCar::getLocation))
        .get()
        .getLocation();

    return racingCars.stream()
        .filter(car -> car.getLocation() == maxLocation)
        .collect(Collectors.toList());
  }

}
