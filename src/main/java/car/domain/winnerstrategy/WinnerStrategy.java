package car.domain.winnerstrategy;

import car.domain.Car;
import java.util.List;

public interface WinnerStrategy {

    List<Car> getWinners(List<Car> cars);
}
