package racing.domain.strategy;

import java.util.Comparator;
import java.util.stream.Collectors;
import racing.domain.Cars;

public class DistanceWinnerStrategy implements WinnerCarStrategy {

  public Cars getWinners(Cars namedCars) {
    int max = namedCars.getDistances().stream().max(Comparator.comparing(Integer::valueOf)).get();
    return new Cars(
        namedCars.getNamedCars().stream().filter(namedCar -> namedCar.getDistance() == max)
            .collect(Collectors.toList()));
  }

}
