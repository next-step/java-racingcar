package racing.domain.strategy;

import java.util.Comparator;
import java.util.stream.Collectors;
import racing.domain.NamedCars;

public class DistanceWinnerStrategy implements WinnerCarStrategy {

  public NamedCars getWinners(NamedCars namedCars) {
    int max = namedCars.getDistances().stream().max(Comparator.comparing(Integer::valueOf)).get();
    return new NamedCars(
        namedCars.getNamedCars().stream().filter(namedCar -> namedCar.getDistance() == max)
            .collect(Collectors.toList()));
  }

}
