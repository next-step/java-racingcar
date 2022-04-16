package racing.domain.strategy;

import racing.domain.NamedCars;

public interface WinnerCarStrategy {

  NamedCars getWinners(NamedCars namedCars);
}
