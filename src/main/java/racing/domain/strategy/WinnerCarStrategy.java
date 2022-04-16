package racing.domain.strategy;

import racing.domain.Cars;

public interface WinnerCarStrategy {

  Cars getWinners(Cars namedCars);
}
