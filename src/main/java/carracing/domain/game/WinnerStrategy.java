package carracing.domain.game;

import carracing.domain.car.Car;
import carracing.domain.car.Winners;

import java.util.List;

public interface WinnerStrategy {
	Winners winners(List<Car> cars);
}
