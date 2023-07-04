package winnerstrategy;

import car.Car;
import java.util.List;

public interface WinnerStrategy {

    List<Car> getWinners(List<Car> cars);
}
